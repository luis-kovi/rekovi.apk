package com.rekovi.taskmanager.data.repository

import com.rekovi.taskmanager.data.source.remote.SupabaseClient
import com.rekovi.taskmanager.data.source.remote.dto.SupabaseCardDto
import com.rekovi.taskmanager.data.source.remote.dto.toDomain
import com.rekovi.taskmanager.domain.model.Card
import com.rekovi.taskmanager.domain.model.PermissionType
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient
) : TaskRepository {

    companion object {
        private val VALID_PHASES = listOf(
            "Fila de Recolha",
            "Aprovar Custo de Recolha",
            "Tentativa 1 de Recolha",
            "Tentativa 2 de Recolha",
            "Tentativa 3 de Recolha",
            "Desbloquear Veículo",
            "Solicitar Guincho",
            "Nova tentativa de recolha",
            "Confirmação de Entrega no Pátio"
        )
    }

    override suspend fun getTasks(permissionType: PermissionType, userEmail: String): List<Card> {
        return try {
            // Fazer query simples sem filtros por enquanto
            val result = supabaseClient.database
                .from("v_pipefy_cards_detalhada")
                .select()
                .decodeList<SupabaseCardDto>()

            result.map { dto: SupabaseCardDto -> dto.toDomain() }
                .filter { card: Card -> 
                    // Filtros básicos
                    card.id.isNotBlank() && card.placa.isNotBlank() &&
                    // Filtro por fases válidas
                    VALID_PHASES.contains(card.faseAtual) &&
                    // Filtros baseados na permissão
                    when (permissionType) {
                        PermissionType.ATIVA, PermissionType.ONSYSTEM -> {
                            card.empresaResponsavel?.contains(permissionType.name, ignoreCase = true) == true
                        }
                        PermissionType.CHOFER -> {
                            card.emailChofer == userEmail
                        }
                        PermissionType.KOVI, PermissionType.ADMIN -> {
                            true // Sem filtros adicionais
                        }
                    }
                }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun observeTasksRealtime(permissionType: PermissionType, userEmail: String): Flow<List<Card>> {
        return flow {
            // Primeiro, emitir dados iniciais
            emit(getTasks(permissionType, userEmail))

            // Para simplificar, vamos apenas reemitir os dados periodicamente
            // TODO: Implementar real-time quando a API estiver estável
            delay(5000)
            emit(getTasks(permissionType, userEmail))
        }
    }

    override suspend fun getTaskById(id: String): Card? {
        return try {
            val results = supabaseClient.database
                .from("v_pipefy_cards_detalhada")
                .select()
                .decodeList<SupabaseCardDto>()

            // Filtrar no lado client por enquanto
            val card = results.find { it.cardId == id }
            card?.toDomain()
        } catch (e: Exception) {
            null
        }
    }

    override fun getValidPhases(): List<String> {
        return VALID_PHASES
    }
}

