import 'dart:io';
import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import '../data/models/card_model.dart';

class MobileTaskModal extends StatefulWidget {
  final CardModel card;
  const MobileTaskModal({super.key, required this.card});

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
                const Text('Fotos do veículo no pátio *', style: TextStyle(fontWeight: FontWeight.w600)),
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
                FilledButton(
                  onPressed: _allPatioValid() ? () {/* submit */} : null,
                  child: const Text('Confirmar'),
                ),
                const SizedBox(height: 16),
              ],

              if (showCarTowed) ...[
                const Text('Foto do veículo no guincho *', style: TextStyle(fontWeight: FontWeight.w600)),
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
                FilledButton(
                  onPressed: _allTowedValid() ? () {/* submit */} : null,
                  child: const Text('Confirmar'),
                ),
                const SizedBox(height: 16),
              ],

              if (showRequestTowMechanical) ...[
                const Text('Detalhe o motivo do guincho *', style: TextStyle(fontWeight: FontWeight.w600)),
                const SizedBox(height: 6),
                TextField(
                  controller: mechanicalTowReason,
                  maxLines: 5,
                  decoration: const InputDecoration(hintText: 'Descreva com detalhes...'),
                ),
                const SizedBox(height: 8),
                FilledButton(
                  onPressed: _allMechanicalValid() ? () {/* submit */} : null,
                  child: const Text('Confirmar'),
                ),
              ],
            ],
          ),
        );
      },
    );
  }
}


