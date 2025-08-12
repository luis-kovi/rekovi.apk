package com.rekovi.taskmanager.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val id: String, // card_id
    val placa: String, // placa_veiculo
    val nomeDriver: String, // nome_driver
    val chofer: String, // nome_chofer_recolha ?: "Pendente"
    val faseAtual: String, // phase_name
    val dataCriacao: String, // created_at
    val emailChofer: String? = null, // email_chofer
    val empresaResponsavel: String? = null, // empresa_recolha
    val modeloVeiculo: String? = null, // modelo_veiculo
    val telefoneContato: String? = null, // telefone_contato
    val telefoneOpcional: String? = null, // telefone_opcional
    val emailCliente: String? = null, // email_cliente
    val enderecoCadastro: String? = null, // endereco_cadastro
    val enderecoRecolha: String? = null, // endereco_recolha
    val linkMapa: String? = null, // link_mapa
    val origemLocacao: String? = null, // origem_locacao
    val valorRecolha: String? = null, // valor_recolha
    val custoKmAdicional: String? = null, // custo_km_adicional
    val urlPublica: String? = null // public_url
) {
    // Propriedades de compatibilidade para o código existente
    val modelo: String get() = modeloVeiculo ?: ""
    val localizacao: String get() = enderecoRecolha ?: ""
    val cidadeOrigem: String get() = origemLocacao ?: ""
    val nomeCliente: String get() = emailCliente ?: ""
    val telefoneCliente: String get() = telefoneContato ?: ""
    val enderecoCliente: String get() = enderecoCadastro ?: ""
    
    // Helper para obter cor da fase
    val phaseColor: PhaseColor
        get() = when (faseAtual) {
            "Fila de Recolha" -> PhaseColor.FILA_RECOLHA
            "Aprovar Custo de Recolha" -> PhaseColor.APROVAR_CUSTO
            "Tentativa 1 de Recolha" -> PhaseColor.TENTATIVA
            "Tentativa 2 de Recolha" -> PhaseColor.TENTATIVA
            "Tentativa 3 de Recolha" -> PhaseColor.TENTATIVA_3
            "Desbloquear Veículo" -> PhaseColor.DESBLOQUEAR
            "Solicitar Guincho" -> PhaseColor.GUINCHO
            "Nova tentativa de recolha" -> PhaseColor.NOVA_TENTATIVA
            "Confirmação de Entrega no Pátio" -> PhaseColor.CONFIRMACAO
            else -> PhaseColor.DEFAULT
        }

    // Helper para obter nome adaptado da fase
    val adaptedPhaseName: String
        get() = when (faseAtual) {
            "Tentativa 1 de Recolha" -> "Tentativa 1"
            "Tentativa 2 de Recolha" -> "Tentativa 2"
            "Tentativa 3 de Recolha" -> "Tentativa 3"
            "Nova tentativa de recolha" -> "Nova Tentativa"
            "Confirmação de Entrega no Pátio" -> "Confirmação de Entrega"
            else -> faseAtual
        }
}

enum class PhaseColor {
    FILA_RECOLHA,
    APROVAR_CUSTO,
    TENTATIVA,
    TENTATIVA_3,
    DESBLOQUEAR,
    GUINCHO,
    NOVA_TENTATIVA,
    CONFIRMACAO,
    DEFAULT
}

