# Rekovi APK - Aplicativo Android Nativo

Este repositório contém um aplicativo Android nativo para o sistema Rekovi de gestão de recolha de veículos.

## 🚀 Estrutura do Projeto

### Componentes Mantidos (Referência Web)
- **Tela de Login**: `app/auth/signin/page.tsx` - Sistema completo de autenticação
- **Página Mobile**: `app/mobile/page.tsx` - Interface mobile principal  
- **Componentes Mobile**: `components/Mobile*` - Componentes otimizados para mobile
- **Configurações Supabase**: `utils/supabase/` - Cliente e servidor
- **Validação de Auth**: `utils/auth-validation.ts` - Lógica de permissões
- **Types**: `types.ts` - Interfaces TypeScript

### App Android Nativo
- **Localização**: `android-task-manager/`
- **Tecnologia**: Kotlin + Jetpack Compose
- **Arquitetura**: MVVM + Hilt + Retrofit

## ⚙️ Configuração

### 1. Configurar Supabase no Android

Edite o arquivo `android-task-manager/app/src/main/java/com/taskmanager/network/SupabaseApiService.kt`:

```kotlin
companion object {
    const val BASE_URL = "https://sua-url-supabase.supabase.co/"
    const val ANON_KEY = "sua-chave-anonima-aqui"
}
```

### 2. Estrutura do Banco de Dados

O app espera as seguintes tabelas/views no Supabase:

- `v_pipefy_cards_detalhada` - View com dados dos cards/tarefas
- `pre_approved_users` - Tabela de usuários pré-aprovados

### 3. Tipos de Permissão

- **admin/kovi**: Acesso total
- **ativa/onsystem**: Acesso por empresa
- **chofer**: Acesso apenas aos próprios cards

## 🛠️ Executar o App Android

### Pré-requisitos
- Android Studio Giraffe+ (2023.2.1+)
- JDK 8+
- Android SDK API 24+

### Passos
1. Abra `android-task-manager/` no Android Studio
2. Configure as credenciais do Supabase
3. Execute o projeto (Shift+F10)

## 📱 Funcionalidades

### Autenticação
- Login com email/senha
- Validação de usuários pré-aprovados
- Controle de permissões por tipo de usuário

### Lista de Tarefas
- Visualização otimizada para mobile
- Filtros por fase e busca por texto
- Pull-to-refresh para atualização
- Real-time updates via Supabase

### Detalhes da Tarefa
- Modal completo com todas as informações
- Links interativos (mapas, URLs)
- Interface responsiva

## 🎨 Design System

### Cores Principais
- **Primary**: `#FF355A` (Vermelho Rekovi)
- **Secondary**: `#E62E4F` (Vermelho escuro)
- **Background**: Gradiente vermelho

### Fases de Cards
- Fila de Recolha
- Aprovar Custo de Recolha
- Tentativa 1/2/3 de Recolha
- Desbloquear Veículo
- Solicitar Guincho
- Nova tentativa de recolha
- Confirmação de Entrega no Pátio

## 📝 Próximos Passos

1. ✅ Integração do design Rekovi
2. ✅ Sistema de autenticação web integrado
3. ✅ Componentes mobile adaptados
4. 🔄 Notificações push
5. 🔄 Modo offline
6. 🔄 Real-time updates
7. 🔄 Biometria

## 🔒 Segurança

- Headers de autenticação automáticos
- Validação de permissões
- Armazenamento seguro de tokens
- Limpeza de dados no logout

---

**Desenvolvido para Rekovi com ❤️ usando Android + Kotlin + Jetpack Compose**