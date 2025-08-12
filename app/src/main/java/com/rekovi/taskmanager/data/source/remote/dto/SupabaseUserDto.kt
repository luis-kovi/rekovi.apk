package com.rekovi.taskmanager.data.source.remote.dto

import com.rekovi.taskmanager.domain.model.PreApprovedUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SupabaseUserDto(
    val email: String,
    
    @SerialName("permission_type")
    val permissionType: String,
    
    val status: String,
    
    val empresa: String,
    
    @SerialName("area_atuacao")
    val areaAtuacao: List<String>? = null,
    
    val nome: String? = null
)

fun SupabaseUserDto.toDomain(): PreApprovedUser {
    return PreApprovedUser(
        email = email,
        permissionType = permissionType,
        status = status,
        empresa = empresa,
        areaAtuacao = areaAtuacao,
        nome = nome
    )
}

