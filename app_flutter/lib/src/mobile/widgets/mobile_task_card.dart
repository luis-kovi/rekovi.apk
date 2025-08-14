import 'package:flutter/material.dart';
import '../../data/models/card_model.dart';

class MobileTaskCard extends StatelessWidget {
  final CardModel card;
  final VoidCallback? onTap;

  const MobileTaskCard({super.key, required this.card, this.onTap});

  Color _phaseColor(String phase) {
    switch (phase) {
      case 'Fila de Recolha':
        return Colors.blue;
      case 'Aprovar Custo de Recolha':
        return Colors.amber;
      case 'Tentativa 1 de Recolha':
      case 'Tentativa 2 de Recolha':
        return Colors.orange;
      case 'Tentativa 3 de Recolha':
        return Colors.red;
      case 'Desbloquear Veículo':
        return Colors.purple;
      case 'Solicitar Guincho':
        return Colors.indigo;
      case 'Nova tentativa de recolha':
        return Colors.green;
      case 'Confirmação de Entrega no Pátio':
        return Colors.teal;
      default:
        return Colors.grey;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 0,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12), side: BorderSide(color: Colors.grey.shade200)),
      child: InkWell(
        borderRadius: BorderRadius.circular(12),
        onTap: onTap,
        child: Padding(
          padding: const EdgeInsets.all(12),
          child: Row(
            children: [
              CircleAvatar(radius: 6, backgroundColor: _phaseColor(card.faseAtual)),
              const SizedBox(width: 12),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('${card.id} · ${card.placa}', style: const TextStyle(fontWeight: FontWeight.w600)),
                    const SizedBox(height: 2),
                    Text('${card.faseAtual} · ${card.nomeDriver}', style: const TextStyle(color: Colors.grey)),
                  ],
                ),
              ),
              const Icon(Icons.chevron_right),
            ],
          ),
        ),
      ),
    );
  }
}


