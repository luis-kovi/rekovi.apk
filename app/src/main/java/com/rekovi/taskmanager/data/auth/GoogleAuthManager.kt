package com.rekovi.taskmanager.data.auth

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume

@Singleton
class GoogleAuthManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    private val credentialManager = CredentialManager.create(context)
    
    /**
     * Web Client ID do Google Console
     * IMPORTANTE: Usado para Supabase Auth (COMPARTILHADO com versão web)
     * NÃO ALTERAR - mantém compatibilidade com versão web
     */
    private val webClientId = "328238966483-cr3gvj8laa7129onpp4i3lqbgf13s7fn.apps.googleusercontent.com"
    
    /**
     * Android Client ID - para usar com SDK tradicional
     * NOVO: Client ID específico para Android (não afeta versão web)
     */
    private val androidClientId = "328238966483-f8v6as8g5v2ms4undp16ck9e1l9b4v9h.apps.googleusercontent.com"
    
    // Google Sign-In client tradicional (fallback)
    private val googleSignInClient: GoogleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(webClientId) // Usa Web Client ID para obter token
            .requestEmail()
            .build()
        GoogleSignIn.getClient(context, gso)
    }
    
    suspend fun signInWithGoogle(): GoogleSignInResult {
        android.util.Log.d("GoogleAuth", "🚀 === INICIANDO GOOGLE SIGN-IN ===")
        
        // Opção A: Tentar Credential Manager primeiro
        return try {
            android.util.Log.d("GoogleAuth", "🧹 Limpando sessão anterior...")
            clearPreviousSession()
            
            android.util.Log.d("GoogleAuth", "🔄 Tentando Credential Manager API...")
            tryCredentialManagerAuth()
        } catch (e: Exception) {
            android.util.Log.w("GoogleAuth", "❌ Credential Manager falhou: ${e.message}")
            android.util.Log.d("GoogleAuth", "🔄 Fallback: SDK tradicional...")
            tryTraditionalGoogleSignIn()
        }
        
        // Opção B: Pular direto para SDK tradicional (descomente se preferir)
        // android.util.Log.d("GoogleAuth", "🎯 Usando SDK tradicional diretamente...")
        // return tryTraditionalGoogleSignInDirect()
    }
    
    private suspend fun clearPreviousSession() {
        try {
            googleSignInClient.signOut()
            android.util.Log.d("GoogleAuth", "✅ Sessão anterior limpa")
        } catch (e: Exception) {
            android.util.Log.w("GoogleAuth", "⚠️ Erro ao limpar sessão: ${e.message}")
        }
    }
    
    private suspend fun tryCredentialManagerAuth(): GoogleSignInResult {
        android.util.Log.d("GoogleAuth", "🔑 Credential Manager - Client ID: $webClientId")
        
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false) // Permite novas contas
            .setAutoSelectEnabled(false) // Não seleciona automaticamente
            .setServerClientId(webClientId)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        val result = credentialManager.getCredential(
            request = request,
            context = context,
        )

        val credential = result.credential
        val googleIdTokenCredential = GoogleIdTokenCredential
            .createFrom(credential.data)

        android.util.Log.d("GoogleAuth", "✅ Credential Manager sucesso: ${googleIdTokenCredential.id}")
        return GoogleSignInResult.Success(
            idToken = googleIdTokenCredential.idToken,
            email = googleIdTokenCredential.id,
            displayName = googleIdTokenCredential.displayName
        )
    }
    
    private suspend fun tryTraditionalGoogleSignIn(): GoogleSignInResult {
        return suspendCancellableCoroutine { continuation ->
            android.util.Log.d("GoogleAuth", "🔄 Tentando SDK tradicional...")
            
            // Limpar sessão anterior
            googleSignInClient.signOut().addOnCompleteListener {
                // Iniciar novo sign-in
                val signInIntent = googleSignInClient.signInIntent
                
                android.util.Log.d("GoogleAuth", "✅ Client IDs configurados:")
                android.util.Log.d("GoogleAuth", "   Web Client ID: $webClientId")
                android.util.Log.d("GoogleAuth", "   Android Client ID: $androidClientId")
                
                continuation.resume(
                    GoogleSignInResult.Error(
                        "Login Google quase pronto! 🎉\n\n" +
                        "Client IDs configurados:\n" +
                        "✅ Web Client ID: ${webClientId.take(20)}...\n" +
                        "✅ Android Client ID: ${androidClientId.take(20)}...\n\n" +
                        "Aguardando implementação final do fluxo.\n" +
                        "Use login email/senha por enquanto."
                    )
                )
            }
        }
    }
}

sealed class GoogleSignInResult {
    data class Success(
        val idToken: String,
        val email: String,
        val displayName: String?
    ) : GoogleSignInResult()
    
    data class Error(val message: String) : GoogleSignInResult()
}
