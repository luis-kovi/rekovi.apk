package com.rekovi.taskmanager.presentation.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.rekovi.taskmanager.domain.model.PreApprovedUser
import com.rekovi.taskmanager.domain.model.User
import com.rekovi.taskmanager.presentation.tasks.components.TaskDetailModal
import com.rekovi.taskmanager.presentation.tasks.components.TaskHeader
import com.rekovi.taskmanager.presentation.tasks.components.TasksList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    user: User,
    preApprovedUser: PreApprovedUser,
    onLogout: () -> Unit,
    onTaskClick: (String) -> Unit,
    tasksViewModel: TasksViewModel = hiltViewModel()
) {
    val uiState by tasksViewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var selectedTaskId by remember { mutableStateOf<String?>(null) }
    var showTaskDetail by remember { mutableStateOf(false) }

    // Inicializar ViewModel com os dados do usuário
    LaunchedEffect(preApprovedUser, user) {
        tasksViewModel.initialize(
            permissionType = preApprovedUser.permissionTypeEnum,
            userEmail = user.email
        )
    }

    // Mostrar erros via Snackbar
    LaunchedEffect(uiState.error) {
        uiState.error?.let { error ->
            snackbarHostState.showSnackbar(
                message = error,
                withDismissAction = true
            )
            tasksViewModel.clearError()
        }
    }

    Scaffold(
        topBar = {
            TaskHeader(
                user = user,
                preApprovedUser = preApprovedUser,
                isUpdating = uiState.isLoading || uiState.isRefreshing,
                onLogout = onLogout
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TasksList(
                    uiState = uiState,
                    onSearchQueryChange = tasksViewModel::updateSearchQuery,
                    onPhaseFilterChange = tasksViewModel::updateSelectedPhase,
                    onRefresh = tasksViewModel::refreshTasks,
                    onTaskClick = onTaskClick
                )
            }
        }

        // Modal de detalhes da tarefa
        if (showTaskDetail && selectedTaskId != null) {
            TaskDetailModal(
                taskId = selectedTaskId!!,
                permissionType = preApprovedUser.permissionTypeEnum,
                onDismiss = { 
                    showTaskDetail = false
                    selectedTaskId = null
                },
                tasksViewModel = tasksViewModel
            )
        }
    }
}

