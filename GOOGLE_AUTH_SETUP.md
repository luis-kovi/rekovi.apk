# 🔐 Configuração do Google OAuth

## Passos para configurar login com Google no app Rekovi

### 1. Google Cloud Console

1. **Acesse**: https://console.cloud.google.com/
2. **Crie um projeto** (se não tiver) ou selecione existente
3. **Ative APIs necessárias**:
   - Vá em "APIs & Services" > "Library"
   - Busque "Google Sign-In API" ou "Google Identity"
   - Clique em "ENABLE"

4. **Configure OAuth consent screen**:
   - Vá em "APIs & Services" > "OAuth consent screen"
   - Escolha "External" (para usuários externos)
   - Preencha:
     - App name: `Rekovi Task Manager`
     - User support email: `seu.email@gmail.com`
     - Developer contact information: `seu.email@gmail.com`
   - Clique "SAVE AND CONTINUE"
   - Em "Scopes": clique "SAVE AND CONTINUE" (usar padrão)
   - Em "Test users": pode adicionar seu email para teste

5. **Crie credenciais OAuth 2.0**:
   - Vá em "APIs & Services" > "Credentials"
   - Clique "CREATE CREDENTIALS" > "OAuth 2.0 Client IDs"
   - Application type: **Web application**
   - Name: `Rekovi Web Client`
   - **Authorized JavaScript origins**: 
     ```
     https://umdcannncnwvrhqivgxp.supabase.co
     ```
   - **Authorized redirect URIs**:
     ```
     https://umdcannncnwvrhqivgxp.supabase.co/auth/v1/callback
     ```
   - Clique "CREATE"
   - **📋 COPIE o Client ID** (exemplo: `123456789-abc123def456.apps.googleusercontent.com`)
   - **📋 COPIE o Client Secret** (exemplo: `GOCSPX-1234567890abcdefghijk`)

### 2. Supabase Dashboard

1. **Acesse**: https://app.supabase.com/project/umdcannncnwvrhqivgxp/auth/providers
2. **Configure Google Provider**:
   - Encontre "Google" na lista de providers
   - **Toggle "Enable sign in with Google"** para ON
   - **Client ID**: Cole o Client ID do passo anterior
   - **Client Secret**: Cole o Client Secret do passo anterior
   - Clique "Save"

### 3. Android Studio - Atualizar código

1. **Abra o arquivo**: `app/src/main/java/com/rekovi/taskmanager/data/auth/GoogleAuthManager.kt`
2. **Substitua a linha**:
   ```kotlin
   private val webClientId = "SEU_WEB_CLIENT_ID_AQUI.apps.googleusercontent.com"
   ```
   **Por**:
   ```kotlin
   private val webClientId = "123456789-abc123def456.apps.googleusercontent.com"
   ```
   *(Use seu Client ID real)*

### 4. Teste no Android Studio

1. **Build** > **Rebuild Project**
2. **Run app** no seu dispositivo
3. **Teste o botão "Continuar com Google"**

### 🔧 Solução de problemas

**Se der erro "OAuth client not found":**
- Verifique se o Client ID está correto
- Confirme que é o **Web Client ID**, não Android Client ID

**Se der erro "redirect_uri_mismatch":**
- Verifique se o redirect URI no Google Console está exato:
  `https://umdcannncnwvrhqivgxp.supabase.co/auth/v1/callback`

**Se der erro "access_denied":**
- Verifique se o Google Provider está habilitado no Supabase
- Confirme que Client ID e Client Secret estão corretos no Supabase

### ✅ Depois de configurar

Quando tudo estiver funcionando:
- ❌ Remova o login por email/senha (opcional)
- ✅ Teste com diferentes contas Google
- ✅ Verifique se usuários aparecem na tabela `pre_approved_users`

---

**📞 Suporte**: Se precisar de ajuda, me informe qual erro está aparecendo!
