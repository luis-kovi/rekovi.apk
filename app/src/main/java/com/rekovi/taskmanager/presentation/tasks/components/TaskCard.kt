package com.rekovi.taskmanager.presentation.tasks.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke // Adicionado
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
// import androidx.compose.material.Text // Certificando que esta linha (se existir) seja removida ou comentada
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rekovi.taskmanager.domain.model.Card
import com.rekovi.taskmanager.presentation.components.icons.RekoviIcons
import com.rekovi.taskmanager.presentation.theme.RekoviColors
import com.rekovi.taskmanager.presentation.theme.RekoviCustomShapes
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun TaskCard(
    task: Card,
    onClick: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = tween(100),
        label = "scale"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .scale(scale)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true,
                    color = RekoviColors.Primary
                ),
                onClick = onClick
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            hoveredElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = RekoviColors.Surface
        ),
        shape = RekoviCustomShapes.taskCard,
        border = BorderStroke(
            width = 1.dp,
            color = RekoviColors.Primary.copy(alpha = 0.1f)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            RekoviColors.Surface,
                            RekoviColors.SurfaceVariant.copy(alpha = 0.3f)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                // Header with plate and priority indicator
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = task.placa,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            ),
                            color = RekoviColors.OnSurface
                        )
                        Text(
                            text = task.modelo,
                            style = MaterialTheme.typography.bodyMedium,
                            color = RekoviColors.OnSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    
                    // Priority dot
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(
                                color = getStatusColor(task.adaptedPhaseName),
                                shape = RekoviCustomShapes.statusBadge
                            )
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Status badge - mais prominente
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = getStatusColor(task.adaptedPhaseName).copy(alpha = 0.12f),
                            shape = RekoviCustomShapes.statusBadge
                        )
                        .border(
                            width = 1.dp,
                            color = getStatusColor(task.adaptedPhaseName).copy(alpha = 0.3f),
                            shape = RekoviCustomShapes.statusBadge
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = task.adaptedPhaseName,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = getStatusColor(task.adaptedPhaseName),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Info rows with modern design
                InfoRowModern(
                    icon = RekoviIcons.User,
                    label = "Driver",
                    value = task.nomeDriver
                )
                
                if (!task.empresaResponsavel.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    InfoRowModern(
                        icon = RekoviIcons.Building,
                        label = "Empresa",
                        value = task.empresaResponsavel
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                InfoRowModern(
                    icon = RekoviIcons.Truck,
                    label = "Chofer",
                    value = if (task.chofer.isNotBlank()) task.chofer else "Pendente"
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // Footer with ID and date
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ID: ${task.id}",
                        style = MaterialTheme.typography.bodySmall,
                        color = RekoviColors.OnSurfaceVariant
                    )
                    
                    Text(
                        text = formatRelativeDate(task.dataCriacao),
                        style = MaterialTheme.typography.bodySmall,
                        color = RekoviColors.OnSurfaceVariant
                    )
                }
            }
            
            // Subtle gradient overlay for depth
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                getStatusColor(task.adaptedPhaseName).copy(alpha = 0.6f),
                                getStatusColor(task.adaptedPhaseName).copy(alpha = 0.2f),
                                Color.Transparent
                            )
                        ),
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    )
                    .align(Alignment.TopCenter)
            )
        }
    }
}

@Composable
private fun InfoRowModern(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(
                    color = RekoviColors.Primary.copy(alpha = 0.1f),
                    shape = RekoviCustomShapes.inputField
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = RekoviColors.Primary
            )
        }
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = RekoviColors.OnSurfaceVariant,
                fontSize = 11.sp
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = RekoviColors.OnSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun getStatusColor(status: String): Color {
    return when {
        status.contains("Fila", ignoreCase = true) -> RekoviColors.Warning
        status.contains("Aprovar", ignoreCase = true) -> RekoviColors.Error
        status.contains("Tentativa", ignoreCase = true) -> RekoviColors.Info
        status.contains("Desbloquear", ignoreCase = true) -> Color(0xFF8B5CF6)
        status.contains("Guincho", ignoreCase = true) -> Color(0xFFEC4899)
        status.contains("Confirmação", ignoreCase = true) -> RekoviColors.Success
        else -> RekoviColors.OnSurfaceVariant
    }
}

private fun formatRelativeDate(dateString: String): String {
    return try {
        val instant = Instant.parse(dateString)
        val now = Clock.System.now()
        val localDate = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        
        val diffDays = (now - instant).inWholeDays
        
        when {
            diffDays == 0L -> "Hoje"
            diffDays == 1L -> "Ontem"
            diffDays <= 7L -> "${diffDays} dias atrás"
            else -> "${localDate.dayOfMonth}/${localDate.monthNumber}/${localDate.year.toString().takeLast(2)}"
        }
    } catch (e: Exception) {
        dateString.take(10) // Fallback to date part
    }
}
