import 'package:supabase_flutter/supabase_flutter.dart';
import '../core/supabase_client.dart';
import 'models/user_data.dart';

class UserRepository {
  final SupabaseClient _sb = SupabaseManager.client;

  Future<UserData?> getUserData(String email) async {
    final res = await _sb
        .from('pre_approved_users')
        .select('email, permission_type, status, empresa, area_atuacao, nome')
        .eq('email', email)
        .maybeSingle();
    if (res == null) return null;
    return UserData.fromMap(res as Map<String, dynamic>);
  }
}


