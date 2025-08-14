import 'dart:io';
import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import '../data/models/card_model.dart';
import '../data/storage_repository.dart';
import '../data/actions_repository.dart';
import '../data/chofer_repository.dart';

class MobileTaskModal extends StatefulWidget {
  final CardModel card;
  final List<String>? userAreas;
  const MobileTaskModal({super.key, required this.card, this.userAreas});

  @override
  State<MobileTaskModal> createState() => _MobileTaskModalState();
}

class _MobileTaskModalState extends State<MobileTaskModal> {
  // Estados para Confirmação de Entrega no Pátio
  bool showConfirmPatioDelivery = false;
  bool showCarTowed = false;
  bool showRequestTowMechanical = false;

  // Fotos do pátio
  final Map<String, File?> patioPhotos = {
    'frente': null,
    'traseira': null,
    'lado_esquerdo': null,
    'lado_direito': null,
    'estepe': null,
    'painel': null,
  };

  // Despesas extras pátio/towed
  final Map<String, bool> extraExpensesPatio = {
    'Gasolina': false,
    'Pedágio': false,
    'Estacionamento': false,
    'Motoboy (busca de chave)': false,
  };
  final Map<String, String> patioExpenseValues = {};
  final Map<String, File?> patioExpenseReceipts = {};

  File? towedCarPhoto;
  final Map<String, bool> extraExpensesTowed = {
    'Gasolina': false,
    'Pedágio': false,
    'Estacionamento': false,
    'Motoboy (busca de chave)': false,
  };
  final Map<String, String> towedExpenseValues = {};
  final Map<String, File?> towedExpenseReceipts = {};

  final TextEditingController mechanicalTowReason = TextEditingController();

  // Alocar chofer
  final TextEditingController collectionDate = TextEditingController();
  final TextEditingController collectionTime = TextEditingController();
  String? selectedChofer;
  String? choferEmail;
  List<Map<String, String>> availableChofers = const [];
  bool _loadingChofers = false;
  bool _submitting = false;
  double _progress = 0.0; // 0..1
  int _totalUploads = 0;
  int _completedUploads = 0;
  String _choferQuery = '';

  @override
  void initState() {
    super.initState();
    _loadChofers();
  }

  Future<void> _loadChofers() async {
    setState(() => _loadingChofers = true);
    try {
      final repo = ChoferRepository();
      availableChofers = await repo.fetchAvailableChofers(
        empresa: widget.card.empresaResponsavel,
        areas: widget.userAreas,
      );
    } catch (_) {
      availableChofers = const [];
    } finally {
      if (mounted) setState(() => _loadingChofers = false);
    }
  }

  bool _assignChoferValid() =>
      (selectedChofer != null && (choferEmail?.isNotEmpty ?? false) && collectionDate.text.isNotEmpty && collectionTime.text.isNotEmpty);

  Future<void> _submitAssignChofer() async {
    final actions = ActionsRepository();
    await actions.saveAssignChofer(
      cardId: widget.card.id,
      choferName: selectedChofer!,
      choferEmail: choferEmail!,
      date: collectionDate.text,
      time: collectionTime.text,
    );
    if (mounted) ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Chofer alocado com sucesso.')));
  }

  Future<void> _pickImage(Function(File) setter) async {
    final img = await ImagePicker().pickImage(source: ImageSource.camera, imageQuality: 85);
    if (img != null) setter(File(img.path));
    setState(() {});
  }

  Future<void> _pickFile(Function(File) setter) async {
    final res = await FilePicker.platform.pickFiles(type: FileType.image);
    final f = res?.files.single;
    if (f != null && f.path != null) setter(File(f.path!));
    setState(() {});
  }

  Widget _expenseFields(Map<String, bool> flags, Map<String, String> values, Map<String, File?> receipts) {
    final entries = flags.entries.where((e) => e.value).map((e) => e.key).toList();
    if (entries.isEmpty) return const SizedBox.shrink();
    return Column(
      children: [
        const SizedBox(height: 8),
        ...entries.map((name) => Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('Valor de $name *', style: const TextStyle(fontWeight: FontWeight.w600)),
                const SizedBox(height: 6),
                TextField(
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(hintText: 'R$ 0,00'),
                  onChanged: (v) => values[name] = v,
                ),
                const SizedBox(height: 6),
                Row(
                  children: [
                    Expanded(
                      child: OutlinedButton.icon(
                        onPressed: () => _pickFile((f) => receipts[name] = f),
                        icon: const Icon(Icons.attachment),
                        label: Text(receipts[name] != null ? 'Comprovante selecionado' : 'Anexar comprovante *'),
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 12),
              ],
            ))
      ],
    );
  }

  bool _allPatioValid() {
    final filledPhotos = patioPhotos.values.every((f) => f != null);
    final anyExpense = extraExpensesPatio.values.any((v) => v);
    final expenseOk = !anyExpense || extraExpensesPatio.keys.every((k) => !extraExpensesPatio[k]! || (patioExpenseValues[k]?.isNotEmpty == true && patioExpenseReceipts[k] != null));
    return filledPhotos && expenseOk;
  }

  bool _allTowedValid() {
    final hasPhoto = towedCarPhoto != null;
    final anyExpense = extraExpensesTowed.values.any((v) => v);
    final expenseOk = !anyExpense || extraExpensesTowed.keys.every((k) => !extraExpensesTowed[k]! || (towedExpenseValues[k]?.isNotEmpty == true && towedExpenseReceipts[k] != null));
    return hasPhoto && expenseOk;
  }

  bool _allMechanicalValid() => mechanicalTowReason.text.trim().isNotEmpty;

  void _resetProgress(int total) {
    _totalUploads = total;
    _completedUploads = 0;
    _progress = total == 0 ? 0.0 : 0.0001; // mostra barra
  }

  Future<String> _uploadWithProgress(StorageRepository storage, File file, String pathPrefix) async {
    try {
      final url = await storage.uploadFile(file: file, pathPrefix: pathPrefix);
      _completedUploads += 1;
      _progress = _totalUploads == 0 ? 1.0 : _completedUploads / _totalUploads;
      if (mounted) setState(() {});
      return url;
    } catch (_) {
      // retry simples
      final url = await storage.uploadFile(file: file, pathPrefix: pathPrefix);
      _completedUploads += 1;
      _progress = _totalUploads == 0 ? 1.0 : _completedUploads / _totalUploads;
      if (mounted) setState(() {});
      return url;
    }
  }

  Future<void> _submitPatio() async {
    setState(() => _submitting = true);
    final storage = StorageRepository();
    final actions = ActionsRepository();
    // total de uploads = fotos do pátio + comprovantes selecionados
    final numReceipts = extraExpensesPatio.entries.where((e) => e.value).length;
    _resetProgress(patioPhotos.length + numReceipts);
    final Map<String, String> photoUrls = {};
    for (final entry in patioPhotos.entries) {
      final file = entry.value!;
      final url = await _uploadWithProgress(storage, file, 'cards/${widget.card.id}/patio/${entry.key}');
      photoUrls[entry.key] = url;
    }
    final Map<String, Map<String, String>> expenses = {};
    for (final name in extraExpensesPatio.keys) {
      if (extraExpensesPatio[name] == true) {
        final receipt = patioExpenseReceipts[name]!;
        final receiptUrl = await _uploadWithProgress(storage, receipt, 'cards/${widget.card.id}/patio/expenses/$name');
        expenses[name] = {
          'valor': patioExpenseValues[name] ?? '',
          'comprovanteUrl': receiptUrl,
        };
      }
    }
    try {
      await actions.saveConfirmPatioDelivery(cardId: widget.card.id, photoUrls: photoUrls, expenses: expenses);
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Entrega no pátio salva com sucesso.')));
        setState(() => _submitting = false);
        Navigator.pop(context);
      }
    } catch (e) {
      if (mounted) {
        setState(() => _submitting = false);
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Erro ao salvar. Tente novamente.')));
      }
    }
  }

  Future<void> _submitTowed() async {
    setState(() => _submitting = true);
    final storage = StorageRepository();
    final actions = ActionsRepository();
    _resetProgress(1 + extraExpensesTowed.entries.where((e) => e.value).length);
    final photoUrl = await _uploadWithProgress(storage, towedCarPhoto!, 'cards/${widget.card.id}/towed');
    final Map<String, Map<String, String>> expenses = {};
    for (final name in extraExpensesTowed.keys) {
      if (extraExpensesTowed[name] == true) {
        final receipt = towedExpenseReceipts[name]!;
        final receiptUrl = await _uploadWithProgress(storage, receipt, 'cards/${widget.card.id}/towed/expenses/$name');
        expenses[name] = {
          'valor': towedExpenseValues[name] ?? '',
          'comprovanteUrl': receiptUrl,
        };
      }
    }
    try {
      await actions.saveCarTowed(cardId: widget.card.id, photoUrl: photoUrl, expenses: expenses);
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Carro guinchado salvo com sucesso.')));
        setState(() => _submitting = false);
        Navigator.pop(context);
      }
    } catch (e) {
      if (mounted) {
        setState(() => _submitting = false);
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Erro ao salvar. Tente novamente.')));
      }
    }
  }

  Future<void> _submitMechanical() async {
    setState(() => _submitting = true);
    final actions = ActionsRepository();
    try {
      await actions.saveMechanicalTow(cardId: widget.card.id, reason: mechanicalTowReason.text.trim());
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Solicitação de guincho salva.')));
        setState(() => _submitting = false);
        Navigator.pop(context);
      }
    } catch (e) {
      if (mounted) {
        setState(() => _submitting = false);
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Erro ao salvar. Tente novamente.')));
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    final isConfirmPhase = widget.card.faseAtual == 'Confirmação de Entrega no Pátio';
    return DraggableScrollableSheet(
      expand: false,
      initialChildSize: 0.9,
      minChildSize: 0.5,
      builder: (_, controller) {
        return Container(
          decoration: const BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.vertical(top: Radius.circular(16)),
          ),
          child: ListView(
            controller: controller,
            padding: const EdgeInsets.all(16),
            children: [
              if (_submitting)
                Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    LinearProgressIndicator(value: _progress == 0.0 ? null : _progress),
                    const SizedBox(height: 8),
                  ],
                ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text('Card ${widget.card.id}', style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16)),
                  IconButton(onPressed: () => Navigator.pop(context), icon: const Icon(Icons.close)),
                ],
              ),
              const SizedBox(height: 8),
              if (isConfirmPhase) ...[
                Wrap(
                  spacing: 8,
                  runSpacing: 8,
                  children: [
                    FilterChip(
                      label: const Text('Confirmar entrega no pátio'),
                      selected: showConfirmPatioDelivery,
                      onSelected: (v) => setState(() => showConfirmPatioDelivery = v),
                    ),
                    FilterChip(
                      label: const Text('Carro guinchado'),
                      selected: showCarTowed,
                      onSelected: (v) => setState(() => showCarTowed = v),
                    ),
                    FilterChip(
                      label: const Text('Solicitar guincho (mecânicos)'),
                      selected: showRequestTowMechanical,
                      onSelected: (v) => setState(() => showRequestTowMechanical = v),
                    ),
                  ],
                ),
                const SizedBox(height: 12),
              ],

              if (showConfirmPatioDelivery) ...[
                // Alocar chofer (layout vertical com Data/Hora)
                const SizedBox(height: 8),
                const Text('Alocar chofer', style: TextStyle(fontWeight: FontWeight.bold)),
                const SizedBox(height: 8),
                if (selectedChofer == null && (_choferQuery.isEmpty))
                  const Text('Selecione um chofer para prosseguir.', style: TextStyle(color: Colors.red)),
                if (_loadingChofers) const LinearProgressIndicator(),
                TextField(
                  onChanged: (v) => setState(() => _choferQuery = v.trim().toLowerCase()),
                  decoration: const InputDecoration(hintText: 'Buscar chofer...'),
                ),
                const SizedBox(height: 8),
                DropdownButtonFormField<String>(
                  value: selectedChofer,
                  decoration: const InputDecoration(labelText: 'Chofer *'),
                  items: availableChofers
                      .where((c) => _choferQuery.isEmpty || (c['name'] ?? '').toLowerCase().contains(_choferQuery))
                      .map((c) => DropdownMenuItem(
                            value: c['name'],
                            child: Text(c['name'] ?? ''),
                          ))
                      .toList(),
                  onChanged: (v) {
                    setState(() {
                      selectedChofer = v;
                      final found = availableChofers.firstWhere(
                        (e) => e['name'] == v,
                        orElse: () => {'email': ''},
                      );
                      choferEmail = found['email'];
                    });
                  },
                ),
                const SizedBox(height: 8),
                if (selectedChofer != null && (choferEmail?.isNotEmpty ?? false))
                  TextFormField(
                    readOnly: true,
                    initialValue: choferEmail,
                    decoration: const InputDecoration(labelText: 'E-mail do Chofer'),
                  ),
                const SizedBox(height: 12),
                FilledButton(
                  onPressed: _assignChoferValid() ? _submitAssignChofer : null,
                  child: const Text('Confirmar alocação'),
                ),
                const SizedBox(height: 16),
                TextFormField(
                  controller: collectionDate,
                  readOnly: true,
                  decoration: const InputDecoration(labelText: 'Data prevista de recolha *'),
                  onTap: () async {
                    final now = DateTime.now();
                    final picked = await showDatePicker(
                      context: context,
                      firstDate: now.subtract(const Duration(days: 0)),
                      lastDate: now.add(const Duration(days: 365)),
                      initialDate: now,
                    );
                    if (picked != null) {
                      collectionDate.text = '${picked.year}-${picked.month.toString().padLeft(2, '0')}-${picked.day.toString().padLeft(2, '0')}';
                    }
                  },
                ),
                const SizedBox(height: 12),
                TextFormField(
                  controller: collectionTime,
                  readOnly: true,
                  decoration: const InputDecoration(labelText: 'Hora prevista de recolha *'),
                  onTap: () async {
                    final picked = await showTimePicker(
                      context: context,
                      initialTime: TimeOfDay.now(),
                    );
                    if (picked != null) {
                      collectionTime.text = picked.format(context);
                    }
                  },
                ),
                const SizedBox(height: 12),
                const Text('Fotos do veículo no pátio *', style: TextStyle(fontWeight: FontWeight.w600)),
                if (!patioPhotos.values.every((f) => f != null))
                  const Padding(
                    padding: EdgeInsets.only(top: 4.0, bottom: 4.0),
                    child: Text('Todas as fotos são obrigatórias.', style: TextStyle(color: Colors.red)),
                  ),
                const SizedBox(height: 8),
                GridView.count(
                  shrinkWrap: true,
                  physics: const NeverScrollableScrollPhysics(),
                  crossAxisCount: 3,
                  crossAxisSpacing: 8,
                  mainAxisSpacing: 8,
                  children: patioPhotos.keys.map((k) {
                    final f = patioPhotos[k];
                    return OutlinedButton(
                      onPressed: () => _pickImage((file) => patioPhotos[k] = file),
                      child: f == null
                          ? Text(k)
                          : Image.file(f, fit: BoxFit.cover),
                    );
                  }).toList(),
                ),
                const SizedBox(height: 8),
                const Text('Houveram despesas extras no processo de recolha?'),
                const SizedBox(height: 6),
                ...extraExpensesPatio.keys.map((k) => CheckboxListTile(
                      value: extraExpensesPatio[k],
                      onChanged: (v) => setState(() => extraExpensesPatio[k] = v ?? false),
                      title: Text(k),
                    )),
                _expenseFields(extraExpensesPatio, patioExpenseValues, patioExpenseReceipts),
                const SizedBox(height: 8),
                FilledButton(onPressed: _allPatioValid() ? _submitPatio : null, child: const Text('Confirmar')),
                const SizedBox(height: 16),
              ],

              if (showCarTowed) ...[
                const Text('Foto do veículo no guincho *', style: TextStyle(fontWeight: FontWeight.w600)),
                if (towedCarPhoto == null)
                  const Padding(
                    padding: EdgeInsets.only(top: 4.0, bottom: 4.0),
                    child: Text('A foto é obrigatória.', style: TextStyle(color: Colors.red)),
                  ),
                const SizedBox(height: 8),
                SizedBox(
                  height: 120,
                  child: OutlinedButton(
                    onPressed: () => _pickImage((f) => towedCarPhoto = f),
                    child: towedCarPhoto == null ? const Text('Selecionar foto') : Image.file(towedCarPhoto!, fit: BoxFit.cover),
                  ),
                ),
                const SizedBox(height: 8),
                const Text('Houveram despesas extras no processo de recolha?'),
                const SizedBox(height: 6),
                ...extraExpensesTowed.keys.map((k) => CheckboxListTile(
                      value: extraExpensesTowed[k],
                      onChanged: (v) => setState(() => extraExpensesTowed[k] = v ?? false),
                      title: Text(k),
                    )),
                _expenseFields(extraExpensesTowed, towedExpenseValues, towedExpenseReceipts),
                const SizedBox(height: 8),
                FilledButton(onPressed: _allTowedValid() ? _submitTowed : null, child: const Text('Confirmar')),
                const SizedBox(height: 16),
              ],

              if (showRequestTowMechanical) ...[
                const Text('Detalhe o motivo do guincho *', style: TextStyle(fontWeight: FontWeight.w600)),
                if (mechanicalTowReason.text.trim().isEmpty)
                  const Padding(
                    padding: EdgeInsets.only(top: 4.0, bottom: 4.0),
                    child: Text('Campo obrigatório.', style: TextStyle(color: Colors.red)),
                  ),
                const SizedBox(height: 6),
                TextField(
                  controller: mechanicalTowReason,
                  maxLines: 5,
                  decoration: const InputDecoration(hintText: 'Descreva com detalhes...'),
                ),
                const SizedBox(height: 8),
                FilledButton(onPressed: _allMechanicalValid() ? _submitMechanical : null, child: const Text('Confirmar')),
              ],
            ],
          ),
        );
      },
    );
  }
}


