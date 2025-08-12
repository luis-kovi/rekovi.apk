package com.rekovi.taskmanager.domain.model

sealed class AuthState {
    object Loading : AuthState()
    object Unauthenticated : AuthState()
    data class Authenticated(
        val user: User,
        val preApprovedUser: PreApprovedUser
    ) : AuthState()
    data class Error(val message: String) : AuthState()
}

data class LoginRequest(
    val email: String,
    val password: String
)

sealed class AuthResult {
    data class Success(
        val user: User,
        val preApprovedUser: PreApprovedUser
    ) : AuthResult()
    data class Error(val message: String) : AuthResult()
}

