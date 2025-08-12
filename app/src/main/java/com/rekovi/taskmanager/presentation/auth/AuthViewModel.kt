package com.rekovi.taskmanager.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rekovi.taskmanager.data.auth.GoogleAuthManager
import com.rekovi.taskmanager.data.auth.GoogleSignInResult
import com.rekovi.taskmanager.data.repository.AuthRepository
import com.rekovi.taskmanager.domain.model.AuthResult
import com.rekovi.taskmanager.domain.model.AuthState
import com.rekovi.taskmanager.domain.model.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val googleAuthManager: GoogleAuthManager
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        checkAuthStatus()
    }

    private fun checkAuthStatus() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            
            try {
                val currentUser = authRepository.getCurrentUser()
                if (currentUser != null) {
                    val preApprovedUser = authRepository.getUserPermissions(currentUser.email)
                    if (preApprovedUser != null && preApprovedUser.isActive) {
                        _authState.value = AuthState.Authenticated(currentUser, preApprovedUser)
                    } else {
                        _authState.value = AuthState.Unauthenticated
                    }
                } else {
                    _authState.value = AuthState.Unauthenticated
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Unauthenticated
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            
            val loginRequest = LoginRequest(
                email = email.trim(),
                password = password
            )
            
            when (val result = authRepository.login(loginRequest)) {
                is AuthResult.Success -> {
                    _authState.value = AuthState.Authenticated(
                        user = result.user,
                        preApprovedUser = result.preApprovedUser
                    )
                }
                is AuthResult.Error -> {
                    _authState.value = AuthState.Error(result.message)
                }
            }
            
            _isLoading.value = false
        }
    }

    fun loginWithGoogle() {
        viewModelScope.launch {
            _isLoading.value = true
            
            when (val result = googleAuthManager.signInWithGoogle()) {
                is GoogleSignInResult.Success -> {
                    when (val authResult = authRepository.loginWithGoogle(
                        idToken = result.idToken,
                        email = result.email,
                        displayName = result.displayName
                    )) {
                        is AuthResult.Success -> {
                            _authState.value = AuthState.Authenticated(
                                user = authResult.user,
                                preApprovedUser = authResult.preApprovedUser
                            )
                        }
                        is AuthResult.Error -> {
                            _authState.value = AuthState.Error(authResult.message)
                        }
                    }
                }
                is GoogleSignInResult.Error -> {
                    _authState.value = AuthState.Error(result.message)
                }
            }
            
            _isLoading.value = false
        }
    }

    fun logout() {
        viewModelScope.launch {
            _isLoading.value = true
            authRepository.logout()
            _authState.value = AuthState.Unauthenticated
            _isLoading.value = false
        }
    }

    fun clearError() {
        if (_authState.value is AuthState.Error) {
            _authState.value = AuthState.Unauthenticated
        }
    }

    fun refreshSession() {
        viewModelScope.launch {
            val success = authRepository.refreshSession()
            if (!success) {
                _authState.value = AuthState.Unauthenticated
            }
        }
    }
}

