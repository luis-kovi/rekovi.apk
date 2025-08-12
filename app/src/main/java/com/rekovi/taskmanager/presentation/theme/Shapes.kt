package com.rekovi.taskmanager.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Sistema de formas da Rekovi - bordas arredondadas modernas
val RekoviShapes = Shapes(
    // Extra small - Para badges pequenos e indicadores
    extraSmall = RoundedCornerShape(4.dp),
    
    // Small - Para chips, tags, botões pequenos
    small = RoundedCornerShape(8.dp),
    
    // Medium - Para cards, botões padrão
    medium = RoundedCornerShape(12.dp),
    
    // Large - Para modais, sheets, containers grandes
    large = RoundedCornerShape(16.dp),
    
    // Extra large - Para elementos principais, telas
    extraLarge = RoundedCornerShape(24.dp)
)

// Shapes customizados para componentes específicos
object RekoviCustomShapes {
    // Para cards de tarefas
    val taskCard = RoundedCornerShape(12.dp)
    
    // Para bottom sheets
    val bottomSheet = RoundedCornerShape(
        topStart = 24.dp,
        topEnd = 24.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
    
    // Para FABs
    val fab = RoundedCornerShape(16.dp)
    
    // Para badges de status
    val statusBadge = RoundedCornerShape(20.dp)
    
    // Para campos de input
    val inputField = RoundedCornerShape(8.dp)
    
    // Para botões principais
    val primaryButton = RoundedCornerShape(12.dp)
    
    // Para chips de filtro
    val filterChip = RoundedCornerShape(20.dp)
    
    // Para containers de glassmorphism
    val glassContainer = RoundedCornerShape(16.dp)
}
