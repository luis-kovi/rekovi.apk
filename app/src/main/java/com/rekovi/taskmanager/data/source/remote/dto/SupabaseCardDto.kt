package com.rekovi.taskmanager.data.source.remote.dto

import com.rekovi.taskmanager.domain.model.Card
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SupabaseCardDto(
    @SerialName("card_id")
    val cardId: String,
    
    @SerialName("placa_veiculo")
    val placaVeiculo: String,
    
    @SerialName("nome_driver")
    val nomeDriver: String,
    
    @SerialName("nome_chofer_recolha")
    val nomeChoferRecolha: String? = null,
    
    @SerialName("phase_name")
    val phaseName: String,
    
    @SerialName("created_at")
    val createdAt: String,
    
    @SerialName("email_chofer")
    val emailChofer: String? = null,
    
    @SerialName("empresa_recolha")
    val empresaRecolha: String? = null,
    
    @SerialName("modelo_veiculo")
    val modeloVeiculo: String? = null,
    
    @SerialName("telefone_contato")
    val telefoneContato: String? = null,
    
    @SerialName("telefone_opcional")
    val telefoneOpcional: String? = null,
    
    @SerialName("email_cliente")
    val emailCliente: String? = null,
    
    @SerialName("endereco_cadastro")
    val enderecoCadastro: String? = null,
    
    @SerialName("endereco_recolha")
    val enderecoRecolha: String? = null,
    
    @SerialName("link_mapa")
    val linkMapa: String? = null,
    
    @SerialName("origem_locacao")
    val origemLocacao: String? = null,
    
    @SerialName("valor_recolha")
    val valorRecolha: String? = null,
    
    @SerialName("custo_km_adicional")
    val custoKmAdicional: String? = null,
    
    @SerialName("public_url")
    val publicUrl: String? = null
)

fun SupabaseCardDto.toDomain(): Card {
    return Card(
        id = cardId,
        placa = placaVeiculo,
        nomeDriver = nomeDriver,
        chofer = nomeChoferRecolha ?: "",
        faseAtual = phaseName,
        dataCriacao = createdAt,
        emailChofer = emailChofer,
        empresaResponsavel = empresaRecolha,
        modeloVeiculo = modeloVeiculo,
        telefoneContato = telefoneContato,
        telefoneOpcional = telefoneOpcional,
        emailCliente = emailCliente,
        enderecoCadastro = enderecoCadastro,
        enderecoRecolha = enderecoRecolha,
        linkMapa = linkMapa,
        origemLocacao = origemLocacao,
        valorRecolha = valorRecolha,
        custoKmAdicional = custoKmAdicional,
        urlPublica = publicUrl
    )
}

