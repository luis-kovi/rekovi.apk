package com.rekovi.taskmanager.presentation.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rekovi.taskmanager.data.repository.TaskRepository
import com.rekovi.taskmanager.domain.model.Card
import com.rekovi.taskmanager.domain.model.PermissionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TasksUiState(
    val tasks: List<Card> = emptyList(),
    val filteredTasks: List<Card> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null,
    val searchQuery: String = "",
    val selectedPhase: String? = null,
    val availablePhases: List<String> = emptyList()
)

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TasksUiState())
    val uiState: StateFlow<TasksUiState> = _uiState.asStateFlow()

    private var permissionType: PermissionType = PermissionType.CHOFER
    private var userEmail: String = ""

    init {
        _uiState.value = _uiState.value.copy(
            availablePhases = taskRepository.getValidPhases()
        )
    }

    fun initialize(permissionType: PermissionType, userEmail: String) {
        this.permissionType = permissionType
        this.userEmail = userEmail
        loadTasks()
        observeRealTimeUpdates()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                val tasks = taskRepository.getTasks(permissionType, userEmail)
                updateTasksAndFilter(tasks)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = "Erro ao carregar tarefas: ${e.message}",
                    isLoading = false
                )
            }
        }
    }

    private fun observeRealTimeUpdates() {
        viewModelScope.launch {
            taskRepository.observeTasksRealtime(permissionType, userEmail)
                .catch { e ->
                    _uiState.value = _uiState.value.copy(
                        error = "Erro nas atualizações em tempo real: ${e.message}"
                    )
                }
                .collect { tasks ->
                    updateTasksAndFilter(tasks)
                }
        }
    }

    private fun updateTasksAndFilter(tasks: List<Card>) {
        val filteredTasks = filterTasks(
            tasks = tasks,
            searchQuery = _uiState.value.searchQuery,
            selectedPhase = _uiState.value.selectedPhase
        )
        
        _uiState.value = _uiState.value.copy(
            tasks = tasks,
            filteredTasks = filteredTasks,
            isLoading = false,
            isRefreshing = false
        )
    }

    fun refreshTasks() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isRefreshing = true)
            
            try {
                val tasks = taskRepository.getTasks(permissionType, userEmail)
                updateTasksAndFilter(tasks)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = "Erro ao atualizar tarefas: ${e.message}",
                    isRefreshing = false
                )
            }
        }
    }

    fun updateSearchQuery(query: String) {
        val filteredTasks = filterTasks(
            tasks = _uiState.value.tasks,
            searchQuery = query,
            selectedPhase = _uiState.value.selectedPhase
        )
        
        _uiState.value = _uiState.value.copy(
            searchQuery = query,
            filteredTasks = filteredTasks
        )
    }

    fun updateSelectedPhase(phase: String?) {
        val filteredTasks = filterTasks(
            tasks = _uiState.value.tasks,
            searchQuery = _uiState.value.searchQuery,
            selectedPhase = phase
        )
        
        _uiState.value = _uiState.value.copy(
            selectedPhase = phase,
            filteredTasks = filteredTasks
        )
    }

    private fun filterTasks(
        tasks: List<Card>,
        searchQuery: String,
        selectedPhase: String?
    ): List<Card> {
        var filtered = tasks

        // Filtro por busca
        if (searchQuery.isNotBlank()) {
            filtered = filtered.filter { card ->
                card.placa.contains(searchQuery, ignoreCase = true) ||
                card.nomeDriver.contains(searchQuery, ignoreCase = true) ||
                card.chofer.contains(searchQuery, ignoreCase = true) ||
                card.faseAtual.contains(searchQuery, ignoreCase = true)
            }
        }

        // Filtro por fase
        if (!selectedPhase.isNullOrBlank()) {
            filtered = filtered.filter { card ->
                card.faseAtual == selectedPhase
            }
        }

        // Ordenação: sempre ordem crescente de ID (menor ID primeiro)
        return filtered.sortedBy { card ->
            card.id.toIntOrNull() ?: Int.MAX_VALUE
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    suspend fun getTaskById(taskId: String): Card? {
        return try {
            taskRepository.getTaskById(taskId)
        } catch (e: Exception) {
            null
        }
    }
}

