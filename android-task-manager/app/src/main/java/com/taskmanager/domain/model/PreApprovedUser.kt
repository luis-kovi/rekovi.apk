package com.taskmanager.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PreApprovedUser(
    val email: String,
    val permission_type: String,
    val status: String,
    val empresa: String,
    val area_atuacao: List<String>? = null
) {
    val isActive: Boolean get() = status == "active"
    
    val canAccessAll: Boolean get() = permission_type.lowercase() in listOf("kovi", "admin")
    
    val isChofer: Boolean get() = permission_type.lowercase() == "chofer"
    
    val companyFilter: String? get() = if (canAccessAll) null else empresa.lowercase()
}
