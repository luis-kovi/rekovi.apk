# Guia de Configuração - Rekovi APK

## 🔧 Configuração Rápida

### 1. Configurar Credenciais do Supabase

**Arquivo:** `android-task-manager/app/src/main/java/com/taskmanager/network/SupabaseApiService.kt`

```kotlin
companion object {
    const val BASE_URL = "https://SEU_PROJETO.supabase.co/"
    const val ANON_KEY = "SUA_CHAVE_ANONIMA_AQUI"
}
```

### 2. Estrutura do Banco de Dados Requerida

#### Tabela: `pre_approved_users`
```sql
CREATE TABLE pre_approved_users (
    email TEXT PRIMARY KEY,
    permission_type TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'active',
    empresa TEXT NOT NULL,
    area_atuacao JSONB
);
```

#### View: `v_pipefy_cards_detalhada`
```sql
-- Campos obrigatórios
card_id: string
placa_veiculo: string
nome_driver: string
nome_chofer_recolha: string
phase_name: string
created_at: timestamp
email_chofer: string
empresa_recolha: string

-- Campos opcionais
modelo_veiculo: string
telefone_contato: string
telefone_opcional: string
email_cliente: string
endereco_cadastro: string
endereco_recolha: string
link_mapa: string
origem_locacao: string
valor_recolha: string
custo_km_adicional: string
public_url: string
```

### 3. Inserir Dados de Teste

#### Usuário de Teste
```sql
-- Authentication > Users (criar via interface)
Email: admin@teste.com
Password: 123456

-- Inserir na tabela pre_approved_users
INSERT INTO pre_approved_users (email, permission_type, status, empresa, area_atuacao)
VALUES ('admin@teste.com', 'admin', 'active', 'kovi', '["São Paulo", "Rio de Janeiro"]');
```

#### Card/Tarefa de Teste
```sql
INSERT INTO sua_tabela_de_cards (
    card_id, placa_veiculo, nome_driver, nome_chofer_recolha,
    phase_name, email_chofer, empresa_recolha, created_at
) VALUES (
    '12345', 'ABC1234', 'João Silva', 'Pedro Santos',
    'Fila de Recolha', 'pedro@email.com', 'ATIVA', NOW()
);
```

## 🚀 Executar o Projeto

### Pré-requisitos
- Android Studio Giraffe+ (2023.2.1+)
- JDK 8+
- Android SDK API 24+

### Passos de Execução

1. **Abrir o Projeto**
   ```bash
   # Abra a pasta android-task-manager no Android Studio
   cd android-task-manager
   ```

2. **Configurar Credenciais**
   - Edite `SupabaseApiService.kt` com suas credenciais

3. **Sync & Build**
   - Aguarde o Gradle sync
   - Execute "Build > Make Project"

4. **Executar**
   - Conecte dispositivo Android ou inicie emulador
   - Clique em Run (▶️) ou Shift+F10

## 🔍 Teste do Sistema

### Fluxo de Teste Completo
1. Abra o aplicativo
2. Faça login com `admin@teste.com` / `123456`
3. Verifique se as tarefas são carregadas
4. Teste filtros e busca
5. Toque em uma tarefa para ver detalhes
6. Teste pull-to-refresh

### Verificar Permissões
- **Admin/Kovi**: Vê todos os cards
- **Ativa**: Vê apenas cards da empresa "ativa"
- **Chofer**: Vê apenas cards onde email_chofer = email do usuário

## 🐛 Problemas Comuns

### App não conecta com Supabase
- ✅ Verificar URL e chave API
- ✅ Verificar conectividade de internet
- ✅ Testar credenciais no browser

### Login funciona mas não aparecem tarefas
- ✅ Verificar se view `v_pipefy_cards_detalhada` existe
- ✅ Verificar se há dados na view
- ✅ Verificar permission_type do usuário

### Erro de build
- ✅ Clean Project + Rebuild
- ✅ Invalidate Caches and Restart
- ✅ Verificar versão do JDK

## 📦 Build para Produção

### Preparar Release
1. Configurar credenciais de produção
2. Atualizar versionCode/versionName
3. Configurar chave de assinatura

### Gerar APK
```bash
./gradlew assembleRelease
```

### Gerar AAB (Google Play)
```bash
./gradlew bundleRelease
```

## 🔒 Configurações de Segurança

### Para Produção
- [ ] Remover logs de debug
- [ ] Habilitar ProGuard/R8
- [ ] Validar certificados SSL
- [ ] Usar Android Keystore para tokens

### Headers de Segurança
O app automaticamente inclui:
- Authorization Bearer token
- apikey header para Supabase
- Content-Type application/json

## 📞 Suporte

Se encontrar problemas:
1. Verificar este guia de configuração
2. Consultar logs do Android Studio (Logcat)
3. Verificar documentação do Supabase
4. Criar issue no repositório

---

**✅ Configuração concluída!** O app deve estar funcionando corretamente.
