# ⚡ Configuração Rápida - Rekovi APK

## 🎯 Passos Essenciais

### 1. Configurar Credenciais do Supabase

**Arquivo:** `app/src/main/java/com/rekovi/taskmanager/data/source/remote/SupabaseClient.kt`

```kotlin
companion object {
    const val SUPABASE_URL = "https://SEU_PROJETO.supabase.co"
    const val SUPABASE_ANON_KEY = "SUA_CHAVE_ANONIMA_AQUI"
}
```

### 2. Estrutura do Banco de Dados

✅ **Tabelas/Views Requeridas:**
- `pre_approved_users` - Controle de usuários e permissões
- `v_pipefy_cards_detalhada` - View com dados dos cards/tarefas

### 3. Usuário de Teste

```sql
-- 1. Criar usuário no Supabase Auth Dashboard
Email: admin@teste.com
Password: 123456

-- 2. Inserir na tabela pre_approved_users
INSERT INTO pre_approved_users (email, permission_type, status, empresa, area_atuacao)
VALUES ('admin@teste.com', 'admin', 'active', 'kovi', '["São Paulo", "Rio de Janeiro"]');
```

### 4. Executar o Projeto

```bash
# No Android Studio:
1. Abra o projeto (pasta rekovi_apk)
2. Aguarde o Gradle sync
3. Configure as credenciais do Supabase
4. Execute (Shift+F10)
```

## 🔧 Configurações de Build (OBRIGATÓRIAS)

| Componente | Versão | Arquivo |
|------------|--------|---------|
| Gradle | 8.11.1 | `gradle/wrapper/gradle-wrapper.properties` |
| AGP | 8.10.2 | `settings.gradle.kts` |
| Kotlin | 2.2.0 | `settings.gradle.kts` |
| Compile SDK | 35 | `app/build.gradle.kts` |
| Target SDK | 35 | `app/build.gradle.kts` |
| Min SDK | 24 | `app/build.gradle.kts` |

## ✅ Verificação Rápida

### Teste o Login
1. Abra o app
2. Digite: `admin@teste.com` / `123456`
3. Clique em "Entrar"
4. Deve aparecer a lista de tarefas

### Teste as Funcionalidades
- ✅ Busca por placa/motorista
- ✅ Filtros por fase
- ✅ Pull-to-refresh
- ✅ Detalhes da tarefa (toque no card)
- ✅ Links clicáveis (telefones, emails, mapas)

## 🚨 Problemas Comuns

### App não conecta
- ✅ Verificar URL e chave do Supabase
- ✅ Testar internet
- ✅ Verificar se as credenciais funcionam no browser

### Login funciona, mas sem tarefas
- ✅ Verificar se a view `v_pipefy_cards_detalhada` existe
- ✅ Verificar se há dados na view
- ✅ Verificar `permission_type` do usuário

### Erro de build
- ✅ Clean Project + Rebuild
- ✅ Invalidate Caches and Restart
- ✅ Verificar versões no `settings.gradle.kts`

## 📱 Sistema de Permissões

| Tipo | Acesso |
|------|---------|
| **admin/kovi** | Todos os cards |
| **ativa/onsystem** | Apenas cards da empresa correspondente |
| **chofer** | Apenas cards onde `email_chofer` = email do usuário |

## 🎨 Personalização

### Cores da Marca
- Primary: `#FF355A` (Vermelho Rekovi)
- Secondary: `#E62E4F`

### Fases Suportadas
- Fila de Recolha
- Aprovar Custo de Recolha
- Tentativa 1/2/3 de Recolha
- Desbloquear Veículo
- Solicitar Guincho
- Nova tentativa de recolha
- Confirmação de Entrega no Pátio

---

**✨ Projeto pronto para uso!** Qualquer dúvida, consulte o `README.md` completo.

