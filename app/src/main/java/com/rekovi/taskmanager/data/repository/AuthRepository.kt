package com.rekovi.taskmanager.data.repository

import com.rekovi.taskmanager.domain.model.AuthResult
import com.rekovi.taskmanager.domain.model.LoginRequest
import com.rekovi.taskmanager.domain.model.PreApprovedUser
import com.rekovi.taskmanager.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): AuthResult
    suspend fun loginWithGoogle(idToken: String, email: String, displayName: String?): AuthResult
    suspend fun logout()
    suspend fun getCurrentUser(): User?
    suspend fun getUserPermissions(email: String): PreApprovedUser?
    fun isUserLoggedIn(): Flow<Boolean>
    suspend fun refreshSession(): Boolean
}

