import 'package:supabase_flutter/supabase_flutter.dart';
import '../core/supabase_client.dart';
import 'models/card_model.dart';

class CardsRepository {
  final SupabaseClient _sb = SupabaseManager.client;

  static const List<String> validPhases = [
    'Fila de Recolha',
    'Aprovar Custo de Recolha',
    'Tentativa 1 de Recolha',
    'Tentativa 2 de Recolha',
    'Tentativa 3 de Recolha',
    'Desbloquear Veículo',
    'Solicitar Guincho',
    'Nova tentativa de recolha',
    'Confirmação de Entrega no Pátio',
  ];

  Future<List<CardModel>> fetchCards({required String permissionType, required String userEmail}) async {
    PostgrestFilterBuilder query = _sb
        .from('v_pipefy_cards_detalhada')
        .select('card_id, placa_veiculo, nome_driver, nome_chofer_recolha, phase_name, created_at, email_chofer, empresa_recolha, modelo_veiculo, telefone_contato, telefone_opcional, email_cliente, endereco_cadastro, endereco_recolha, link_mapa, origem_locacao, valor_recolha, custo_km_adicional, public_url')
        .inFilter('phase_name', validPhases)
        .order('card_id', ascending: true);

    if (permissionType.toLowerCase() == 'chofer') {
      query = query.eq('email_chofer', userEmail);
    }

    final response = await query.limit(100000);
    final data = response as List<dynamic>?;
    final cards = (data ?? [])
        .map((e) => CardModel.fromMap(e as Map<String, dynamic>))
        .where((c) => c.id.isNotEmpty && c.placa.isNotEmpty)
        .toList();
    return cards;
  }
}


