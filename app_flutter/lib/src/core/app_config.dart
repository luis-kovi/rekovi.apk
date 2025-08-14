class AppConfig {
  // Preencha com as credenciais do seu projeto Supabase
  static const String supabaseUrl = String.fromEnvironment(
    'SUPABASE_URL',
    defaultValue: 'https://SEU_PROJETO.supabase.co',
  );
  static const String supabaseAnonKey = String.fromEnvironment(
    'SUPABASE_ANON_KEY',
    defaultValue: 'SUA_CHAVE_ANONIMA_AQUI',
  );

  // Nome do bucket de Storage a ser usado para uploads
  static const String storageBucket = String.fromEnvironment(
    'SUPABASE_BUCKET',
    defaultValue: 'attachments',
  );
}


