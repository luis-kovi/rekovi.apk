package com.rekovi.taskmanager.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val email: String,
    val fullName: String? = null,
    val avatarUrl: String? = null
)

@Serializable
data class PreApprovedUser(
    val email: String,
    val permissionType: String,
    val status: String,
    val empresa: String,
    val areaAtuacao: List<String>? = null,
    val nome: String? = null
) {
    val isActive: Boolean
        get() = status == "active"

    val permissionTypeEnum: PermissionType
        get() = when (permissionType.lowercase()) {
            "admin" -> PermissionType.ADMIN
            "kovi" -> PermissionType.KOVI
            "ativa" -> PermissionType.ATIVA
            "onsystem" -> PermissionType.ONSYSTEM
            "chofer" -> PermissionType.CHOFER
            else -> PermissionType.CHOFER
        }
}

enum class PermissionType(val displayName: String) {
    ADMIN("Administrador"),
    KOVI("Kovi"),
    ATIVA("Ativa"),
    ONSYSTEM("OnSystem"),
    CHOFER("Chofer")
}

