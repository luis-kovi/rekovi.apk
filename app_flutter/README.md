# Rekovi Mobile (Flutter)

Aplicativo híbrido Flutter idêntico ao design mobile/web atual.

## Requisitos
- Flutter SDK 3.24+
- Dart 3.4+
- Android SDK / emulador

## Primeiros passos
1. Instale o Flutter (Windows):
   - Abra PowerShell como Administrador e execute:
     - choco install flutter -y
   - Reinicie o terminal e valide com flutter --version
2. Vá até a pasta do app:
   - cd app_flutter
3. Instale dependências:
   - flutter pub get
4. Rode o app:
   - flutter run -d windows (para teste rápido) ou flutter run -d emulator-5554 (Android)

## Integração Supabase (a fazer)
- Configurar supabase_flutter para login e busca de cards como na versão web.

## Estrutura
- lib/src/auth/signin_page.dart: tela de login (UI semelhante à web)
- lib/src/mobile/mobile_home_page.dart: placeholder da Home (iremos portar a MobileWrapper e MobileTaskManager)


