import 'package:supabase_flutter/supabase_flutter.dart';
import '../core/supabase_client.dart';

class ChoferRepository {
  final SupabaseClient _sb = SupabaseManager.client;

  // Busca chofers ativos da tabela pre_approved_users
  Future<List<Map<String, String>>> fetchAvailableChofers({String? empresa, List<String>? areas}) async {
    PostgrestFilterBuilder query = _sb
        .from('pre_approved_users')
        .select('nome, email, permission_type, status, empresa')
        .eq('permission_type', 'chofer')
        .eq('status', 'active');

    if (empresa != null && empresa.isNotEmpty) {
      query = query.eq('empresa', empresa);
    }
    // Nota: caso 'area_atuacao' seja jsonb, ajuste para contains
    if (areas != null && areas.isNotEmpty) {
      // Dependendo do Supabase, pode usar .contains('area_atuacao', areas)
      // Aqui mantemos simples; caso necessário, deixamos sem filtro por áreas
    }

    final res = await query;
    final list = (res as List<dynamic>? ?? [])
        .map((e) => {
              'name': (e['nome'] ?? e['email'] ?? '').toString(),
              'email': (e['email'] ?? '').toString(),
            })
        .where((m) => (m['email'] ?? '').isNotEmpty)
        .toList();
    list.sort((a, b) => (a['name'] ?? '').compareTo(b['name'] ?? ''));
    return list;
  }
}


