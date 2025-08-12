package com.rekovi.taskmanager.presentation.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rekovi.taskmanager.R
import com.rekovi.taskmanager.domain.model.Card
import com.rekovi.taskmanager.domain.model.PermissionType
import com.rekovi.taskmanager.presentation.components.LoadingScreen
import com.rekovi.taskmanager.presentation.tasks.TasksViewModel
import kotlinx.coroutines.launch

@Composable
fun TaskDetailModal(
    taskId: String,
    permissionType: PermissionType,
    onDismiss: () -> Unit,
    tasksViewModel: TasksViewModel
) {
    var task by remember { mutableStateOf<Card?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(taskId) {
        scope.launch {
            try {
                task = tasksViewModel.getTaskById(taskId)
            } catch (e: Exception) {
                // Handle error
            } finally {
                isLoading = false
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { /* Prevent dismissing when clicking the card */ },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                if (isLoading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        LoadingScreen()
                    }
                } else if (task != null) {
                    TaskDetailContent(
                        task = task!!,
                        onDismiss = onDismiss
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Erro ao carregar os detalhes da tarefa",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TaskDetailContent(
    task: Card,
    onDismiss: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Detalhes da Tarefa",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            IconButton(onClick = onDismiss) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.close),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Vehicle Info Section
            DetailSection(title = "Informações do Veículo") {
                DetailRow(
                    label = stringResource(id = R.string.plate),
                    value = task.placa,
                    isHighlighted = true
                )
                
                if (!task.modeloVeiculo.isNullOrBlank()) {
                    DetailRow(
                        label = stringResource(id = R.string.vehicle_model),
                        value = task.modeloVeiculo
                    )
                }
                
                DetailRow(
                    label = stringResource(id = R.string.phase),
                    value = task.faseAtual
                )
                
                DetailRow(
                    label = stringResource(id = R.string.created_at),
                    value = formatDate(task.dataCriacao)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // People Info Section
            DetailSection(title = "Pessoas Envolvidas") {
                DetailRow(
                    label = stringResource(id = R.string.driver),
                    value = task.nomeDriver
                )
                
                DetailRow(
                    label = stringResource(id = R.string.chofer),
                    value = if (task.chofer.isNotBlank()) task.chofer else stringResource(id = R.string.pending_allocation)
                )
                
                if (!task.empresaResponsavel.isNullOrBlank()) {
                    DetailRow(
                        label = stringResource(id = R.string.company),
                        value = task.empresaResponsavel
                    )
                }
            }

            // Contact Info Section
            if (!task.telefoneContato.isNullOrBlank() || 
                !task.telefoneOpcional.isNullOrBlank() || 
                !task.emailCliente.isNullOrBlank()) {
                
                Spacer(modifier = Modifier.height(16.dp))
                
                DetailSection(title = "Contatos") {
                    if (!task.telefoneContato.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.contact_phone),
                            value = task.telefoneContato,
                            icon = Icons.Default.Phone,
                            isClickable = true,
                            onClick = { 
                                try {
                                    uriHandler.openUri("tel:${task.telefoneContato}")
                                } catch (e: Exception) {
                                    // Handle error
                                }
                            }
                        )
                    }
                    
                    if (!task.telefoneOpcional.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.optional_phone),
                            value = task.telefoneOpcional,
                            icon = Icons.Default.Phone,
                            isClickable = true,
                            onClick = { 
                                try {
                                    uriHandler.openUri("tel:${task.telefoneOpcional}")
                                } catch (e: Exception) {
                                    // Handle error
                                }
                            }
                        )
                    }
                    
                    if (!task.emailCliente.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.client_email),
                            value = task.emailCliente,
                            icon = Icons.Default.Email,
                            isClickable = true,
                            onClick = { 
                                try {
                                    uriHandler.openUri("mailto:${task.emailCliente}")
                                } catch (e: Exception) {
                                    // Handle error
                                }
                            }
                        )
                    }
                }
            }

            // Addresses Section
            if (!task.enderecoCadastro.isNullOrBlank() || 
                !task.enderecoRecolha.isNullOrBlank()) {
                
                Spacer(modifier = Modifier.height(16.dp))
                
                DetailSection(title = "Endereços") {
                    if (!task.enderecoCadastro.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.registration_address),
                            value = task.enderecoCadastro
                        )
                    }
                    
                    if (!task.enderecoRecolha.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.pickup_address),
                            value = task.enderecoRecolha,
                            icon = Icons.Default.LocationOn,
                            isClickable = !task.linkMapa.isNullOrBlank(),
                            onClick = if (!task.linkMapa.isNullOrBlank()) {
                                { 
                                    try {
                                        uriHandler.openUri(task.linkMapa)
                                    } catch (e: Exception) {
                                        // Handle error
                                    }
                                }
                            } else null
                        )
                    }
                }
            }

            // Financial Info Section
            if (!task.valorRecolha.isNullOrBlank() || 
                !task.custoKmAdicional.isNullOrBlank()) {
                
                Spacer(modifier = Modifier.height(16.dp))
                
                DetailSection(title = "Informações Financeiras") {
                    if (!task.valorRecolha.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.pickup_value),
                            value = task.valorRecolha
                        )
                    }
                    
                    if (!task.custoKmAdicional.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.additional_km_cost),
                            value = task.custoKmAdicional
                        )
                    }
                }
            }

            // Additional Info Section
            if (!task.origemLocacao.isNullOrBlank() || !task.urlPublica.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(16.dp))
                
                DetailSection(title = "Informações Adicionais") {
                    if (!task.origemLocacao.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.origin_location),
                            value = task.origemLocacao
                        )
                    }
                    
                    if (!task.urlPublica.isNullOrBlank()) {
                        DetailRow(
                            label = stringResource(id = R.string.public_url),
                            value = "Ver no Pipefy",
                            isClickable = true,
                            onClick = { 
                                try {
                                    uriHandler.openUri(task.urlPublica)
                                } catch (e: Exception) {
                                    // Handle error
                                }
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun DetailSection(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            content()
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String,
    icon: ImageVector? = null,
    isHighlighted: Boolean = false,
    isClickable: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .let { 
                if (isClickable && onClick != null) {
                    it.clickable { onClick() }
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                        .padding(8.dp)
                } else {
                    it.padding(vertical = 4.dp)
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = if (isClickable) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.width(120.dp)
        )
        
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal
            ),
            color = if (isClickable) MaterialTheme.colorScheme.primary 
                   else if (isHighlighted) MaterialTheme.colorScheme.primary
                   else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f),
            maxLines = if (isClickable) 1 else Int.MAX_VALUE,
            overflow = if (isClickable) TextOverflow.Ellipsis else TextOverflow.Clip
        )
    }
}

private fun formatDate(dateString: String): String {
    return try {
        // Aqui você pode implementar formatação mais sofisticada se necessário
        dateString.take(16).replace("T", " às ")
    } catch (e: Exception) {
        dateString
    }
}

