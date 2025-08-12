package com.rekovi.taskmanager.data.source.remote

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.realtime.realtime
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import io.ktor.client.engine.android.Android

class SupabaseClient {
    
    companion object {
        // TODO: Configurar com suas credenciais do Supabase
        const val SUPABASE_URL = "https://umdcannncnwvrhqivgxp.supabase.co"
        const val SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVtZGNhbm5uY253dnJocWl2Z3hwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTM3NDY5MzksImV4cCI6MjA2OTMyMjkzOX0.41FHshe3ZO1jzcfHN7E4LXCDZOVZHUcGYkXo-3Ioybs"
    }

    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_ANON_KEY
    ) {
        install(Auth)
        install(Postgrest)
        install(Realtime)
        install(Storage)
        
        // Configurar cliente HTTP para Android
        httpEngine = Android.create()
    }

    val auth get() = client.auth
    val database get() = client.postgrest
    val realtime get() = client.realtime
    val storage get() = client.storage
}
