package com.rekovi.taskmanager.data.repository

import com.rekovi.taskmanager.data.source.local.PreferencesManager
import com.rekovi.taskmanager.data.source.remote.SupabaseClient
import com.rekovi.taskmanager.data.source.remote.dto.SupabaseUserDto
import com.rekovi.taskmanager.data.source.remote.dto.toDomain
import com.rekovi.taskmanager.domain.model.AuthResult
import com.rekovi.taskmanager.domain.model.LoginRequest
import com.rekovi.taskmanager.domain.model.PreApprovedUser
import com.rekovi.taskmanager.domain.model.User
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.providers.builtin.IDToken
import io.github.jan.supabase.postgrest.from

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient,
    private val preferencesManager: PreferencesManager
) : AuthRepository {

    override suspend fun loginWithGoogle(idToken: String, email: String, displayName: String?): AuthResult {
        return try {
            // Autenticar com Google via Supabase
            val authResult = supabaseClient.auth.signInWith(IDToken) {
                this.idToken = idToken
                provider = io.github.jan.supabase.gotrue.providers.Google
            }

            val user = supabaseClient.auth.currentUserOrNull()
            if (user != null) {
                // Verificar se o usuário está na tabela pre_approved_users
                val preApprovedUser = getUserPermissions(email)
                
                if (preApprovedUser == null) {
                    return AuthResult.Error("Usuário não cadastrado, consulte o administrador do sistema")
                }
                
                if (!preApprovedUser.isActive) {
                    return AuthResult.Error("Usuário desativado, consulte o administrador do sistema")
                }

                // Salvar tokens e informações do usuário
                val session = supabaseClient.auth.currentSessionOrNull()
                if (session != null) {
                    preferencesManager.saveTokens(
                        accessToken = session.accessToken,
                        refreshToken = session.refreshToken ?: ""
                    )
                    preferencesManager.saveUserInfo(
                        userId = user.id,
                        email = email,
                        permissionType = preApprovedUser.permissionType
                    )
                }

                val domainUser = User(
                    id = user.id,
                    email = email,
                    fullName = displayName ?: user.userMetadata?.get("full_name") as? String,
                    avatarUrl = user.userMetadata?.get("avatar_url") as? String
                )

                AuthResult.Success(domainUser, preApprovedUser)
            } else {
                AuthResult.Error("Erro de autenticação com Google")
            }
        } catch (e: RestException) {
            AuthResult.Error("Erro de autenticação Google: ${e.message}")
        } catch (e: Exception) {
            AuthResult.Error("Erro de conexão Google: ${e.message}")
        }
    }

    override suspend fun login(loginRequest: LoginRequest): AuthResult {
        return try {
            // Autenticar com Supabase
            val authResult = supabaseClient.auth.signInWith(Email) {
                email = loginRequest.email
                password = loginRequest.password
            }

            val user = supabaseClient.auth.currentUserOrNull()
            if (user != null) {
                // Verificar se o usuário está na tabela pre_approved_users
                val preApprovedUser = getUserPermissions(user.email ?: "")
                
                if (preApprovedUser == null) {
                    return AuthResult.Error("Usuário não cadastrado, consulte o administrador do sistema")
                }
                
                if (!preApprovedUser.isActive) {
                    return AuthResult.Error("Usuário desativado, consulte o administrador do sistema")
                }

                // Salvar tokens e informações do usuário
                val session = supabaseClient.auth.currentSessionOrNull()
                if (session != null) {
                    preferencesManager.saveTokens(
                        accessToken = session.accessToken,
                        refreshToken = session.refreshToken ?: ""
                    )
                    preferencesManager.saveUserInfo(
                        userId = user.id,
                        email = user.email ?: "",
                        permissionType = preApprovedUser.permissionType
                    )
                }

                val domainUser = User(
                    id = user.id,
                    email = user.email ?: "",
                    fullName = user.userMetadata?.get("full_name") as? String,
                    avatarUrl = user.userMetadata?.get("avatar_url") as? String
                )

                AuthResult.Success(domainUser, preApprovedUser)
            } else {
                AuthResult.Error("Erro de autenticação")
            }
        } catch (e: RestException) {
            when (e.error) {
                "invalid_grant" -> AuthResult.Error("E-mail ou senha inválidos")
                "email_not_confirmed" -> AuthResult.Error("Confirme seu e-mail antes de fazer login")
                else -> AuthResult.Error("Erro de autenticação: ${e.message}")
            }
        } catch (e: Exception) {
            AuthResult.Error("Erro de conexão: ${e.message}")
        }
    }

    override suspend fun logout() {
        try {
            supabaseClient.auth.signOut()
        } catch (e: Exception) {
            // Ignorar erros de logout
        } finally {
            preferencesManager.clearAll()
        }
    }

    override suspend fun getCurrentUser(): User? {
        return try {
            val user = supabaseClient.auth.currentUserOrNull()
            if (user != null) {
                User(
                    id = user.id,
                    email = user.email ?: "",
                    fullName = user.userMetadata?.get("full_name") as? String,
                    avatarUrl = user.userMetadata?.get("avatar_url") as? String
                )
            } else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getUserPermissions(email: String): PreApprovedUser? {
        return try {
            val results = supabaseClient.database
                .from("pre_approved_users")
                .select()
                .decodeList<SupabaseUserDto>()
            
            // Filtrar no lado client por enquanto
            val user = results.find { it.email == email }
            user?.toDomain()
        } catch (e: Exception) {
            null
        }
    }

    override fun isUserLoggedIn(): Flow<Boolean> {
        return preferencesManager.accessToken.map { token ->
            !token.isNullOrBlank() && supabaseClient.auth.currentUserOrNull() != null
        }
    }

    override suspend fun refreshSession(): Boolean {
        return try {
            val refreshToken = preferencesManager.refreshToken.first()
            if (!refreshToken.isNullOrBlank()) {
                supabaseClient.auth.refreshCurrentSession()
                val session = supabaseClient.auth.currentSessionOrNull()
                if (session != null) {
                    preferencesManager.saveTokens(
                        accessToken = session.accessToken,
                        refreshToken = session.refreshToken ?: ""
                    )
                    true
                } else false
            } else false
        } catch (e: Exception) {
            false
        }
    }
}

