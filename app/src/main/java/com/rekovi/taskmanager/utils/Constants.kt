package com.rekovi.taskmanager.utils

object Constants {
    // Supabase Configuration
    const val SUPABASE_URL = "https://SEU_PROJETO.supabase.co"
    const val SUPABASE_ANON_KEY = "SUA_CHAVE_ANONIMA_AQUI"
    
    // Database Tables/Views
    const val TABLE_PRE_APPROVED_USERS = "pre_approved_users"
    const val VIEW_PIPEFY_CARDS_DETAILED = "v_pipefy_cards_detalhada"
    
    // Valid Phases
    val VALID_PHASES = listOf(
        "Fila de Recolha",
        "Aprovar Custo de Recolha",
        "Tentativa 1 de Recolha",
        "Tentativa 2 de Recolha",
        "Tentativa 3 de Recolha",
        "Desbloquear Veículo",
        "Solicitar Guincho",
        "Nova tentativa de recolha",
        "Confirmação de Entrega no Pátio"
    )
    
    // Permission Types
    object PermissionTypes {
        const val ADMIN = "admin"
        const val KOVI = "kovi"
        const val ATIVA = "ativa"
        const val ONSYSTEM = "onsystem"
        const val CHOFER = "chofer"
    }
    
    // User Status
    object UserStatus {
        const val ACTIVE = "active"
        const val INACTIVE = "inactive"
    }
    
    // App Configuration
    const val MAX_CARDS_LIMIT = 100000
    const val REALTIME_UPDATE_INTERVAL = 10000L // 10 seconds
}

