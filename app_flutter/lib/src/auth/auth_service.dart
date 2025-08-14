import 'package:supabase_flutter/supabase_flutter.dart';
import '../core/supabase_client.dart';

class AuthService {
  final SupabaseClient _sb = SupabaseManager.client;

  Future<AuthResponse> signInWithPassword(String email, String password) async {
    return await _sb.auth.signInWithPassword(email: email, password: password);
  }

  Future<void> signOut() async {
    await _sb.auth.signOut();
  }

  Session? get currentSession => _sb.auth.currentSession;
  User? get currentUser => _sb.auth.currentUser;
}


