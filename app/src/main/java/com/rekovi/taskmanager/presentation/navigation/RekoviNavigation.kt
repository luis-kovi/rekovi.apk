package com.rekovi.taskmanager.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.rekovi.taskmanager.domain.model.AuthState
import com.rekovi.taskmanager.presentation.auth.AuthViewModel
import com.rekovi.taskmanager.presentation.auth.LoginScreen
import com.rekovi.taskmanager.presentation.components.LoadingScreen
import com.rekovi.taskmanager.presentation.tasks.TasksScreen
import com.rekovi.taskmanager.presentation.tasks.components.TaskDetailScreen
import com.rekovi.taskmanager.presentation.tasks.TasksViewModel

@Composable
fun RekoviNavigation(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val authState by authViewModel.authState.collectAsState()

    when (authState) {
        is AuthState.Loading -> {
            LoadingScreen()
        }
        is AuthState.Unauthenticated, is AuthState.Error -> {
            NavHost(
                navController = navController,
                startDestination = Screen.Login.route
            ) {
                composable(Screen.Login.route) {
                    LoginScreen(
                        authViewModel = authViewModel,
                        onLoginSuccess = {
                            navController.navigate(Screen.Tasks.route) {
                                popUpTo(Screen.Login.route) { inclusive = true }
                            }
                        }
                    )
                }
            }
        }
        is AuthState.Authenticated -> {
            // ViewModel compartilhado entre as telas
            val sharedTasksViewModel: TasksViewModel = hiltViewModel()
            
            NavHost(
                navController = navController,
                startDestination = Screen.Tasks.route
            ) {
                composable(Screen.Tasks.route) {
                    val authenticatedState = authState as AuthState.Authenticated
                    TasksScreen(
                        user = authenticatedState.user,
                        preApprovedUser = authenticatedState.preApprovedUser,
                        onLogout = {
                            authViewModel.logout()
                            navController.navigate(Screen.Login.route) {
                                popUpTo(Screen.Tasks.route) { inclusive = true }
                            }
                        },
                        onTaskClick = { taskId ->
                            navController.navigate(Screen.TaskDetail.createRoute(taskId))
                        },
                        tasksViewModel = sharedTasksViewModel
                    )
                }
                
                composable(
                    route = Screen.TaskDetail.route,
                    arguments = listOf(navArgument("taskId") { type = NavType.StringType })
                ) { backStackEntry ->
                    val taskId = backStackEntry.arguments?.getString("taskId")
                    // Usar o mesmo ViewModel compartilhado
                    val uiState by sharedTasksViewModel.uiState.collectAsState()

                    // Forçar carregamento das tarefas se estiver vazio
                    LaunchedEffect(Unit) {
                        if (uiState.tasks.isEmpty()) {
                            sharedTasksViewModel.refreshTasks()
                        }
                    }

                    if (taskId != null) {
                        // Buscar na lista completa primeiro
                        val selectedTask = uiState.tasks.find { it.id == taskId } 
                            ?: uiState.filteredTasks.find { it.id == taskId }
                        
                        if (selectedTask != null) {
                            TaskDetailScreen(
                                card = selectedTask,
                                onBack = {
                                    navController.popBackStack()
                                }
                            )
                        } else {
                            // Tela de erro se tarefa não encontrada
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Tarefa não encontrada",
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Button(
                                        onClick = { navController.popBackStack() }
                                    ) {
                                        Text("Voltar")
                                    }
                                }
                            }
                        }
                    } else {
                        LaunchedEffect(Unit) {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Tasks : Screen("tasks")
    object TaskDetail : Screen("task_detail/{taskId}") {
        fun createRoute(taskId: String) = "task_detail/$taskId"
    }
}
