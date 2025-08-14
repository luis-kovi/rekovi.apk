import 'package:supabase_flutter/supabase_flutter.dart';
import 'app_config.dart';

class SupabaseManager {
  static bool _initialized = false;

  static Future<void> init() async {
    if (_initialized) return;
    await Supabase.initialize(
      url: AppConfig.supabaseUrl,
      anonKey: AppConfig.supabaseAnonKey,
      authFlowType: AuthFlowType.pkce,
    );
    _initialized = true;
  }

  static SupabaseClient get client => Supabase.instance.client;
}


