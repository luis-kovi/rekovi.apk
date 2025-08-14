class AppConfig {
  // Preencha com as credenciais do seu projeto Supabase
  static const String supabaseUrl = String.fromEnvironment(
    'SUPABASE_URL',
    defaultValue: 'https://umdcannncnwvrhqivgxp.supabase.co',
  );
  static const String supabaseAnonKey = String.fromEnvironment(
    'SUPABASE_ANON_KEY',
    defaultValue: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVtZGNhbm5uY253dnJocWl2Z3hwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTM3NDY5MzksImV4cCI6MjA2OTMyMjkzOX0.41FHshe3ZO1jzcfHN7E4LXCDZOVZHUcGYkXo-3Ioybs',
  );

  // Nome do bucket de Storage a ser usado para uploads
  static const String storageBucket = String.fromEnvironment(
    'SUPABASE_BUCKET',
    defaultValue: 'attachments',
  );
}


