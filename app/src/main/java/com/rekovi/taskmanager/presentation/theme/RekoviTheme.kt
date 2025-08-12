package com.rekovi.taskmanager.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Cores baseadas no design da Rekovi
object RekoviColors {
    // Cores primárias da marca
    val Primary = Color(0xFFFF355A) // Vermelho Rekovi
    val PrimaryDark = Color(0xFFE02E4D) // Vermelho mais escuro
    val PrimaryLight = Color(0xFFFF6B82) // Vermelho mais claro
    
    // Cores de superficie e fundo
    val Background = Color(0xFFF7F9FA) // Cinza muito claro
    val Surface = Color(0xFFFFFFFF) // Branco puro
    val SurfaceVariant = Color(0xFFF8FAFC) // Cinza quase branco
    
    // Cores de texto
    val OnBackground = Color(0xFF171717) // Preto suave
    val OnSurface = Color(0xFF171717) // Preto suave
    val OnSurfaceVariant = Color(0xFF64748B) // Cinza médio
    
    // Cores de apoio
    val Success = Color(0xFF10B981) // Verde
    val Warning = Color(0xFFF59E0B) // Amarelo
    val Error = Color(0xFFEF4444) // Vermelho erro
    val Info = Color(0xFF3B82F6) // Azul
    
    // Cores de glassmorphism
    val GlassBackground = Color(0xFFF8FAFC).copy(alpha = 0.8f)
    val GlassOverlay = Color(0xFFFFFFFF).copy(alpha = 0.1f)
    
    // Cores de sombra
    val ShadowLight = Color(0xFF000000).copy(alpha = 0.08f)
    val ShadowMedium = Color(0xFF000000).copy(alpha = 0.15f)
    val ShadowHeavy = Color(0xFF000000).copy(alpha = 0.25f)
}

// Esquema de cores claro
private val LightColorScheme = lightColorScheme(
    primary = RekoviColors.Primary,
    onPrimary = Color.White,
    primaryContainer = RekoviColors.PrimaryLight.copy(alpha = 0.12f),
    onPrimaryContainer = RekoviColors.PrimaryDark,
    
    secondary = RekoviColors.OnSurfaceVariant,
    onSecondary = Color.White,
    secondaryContainer = RekoviColors.OnSurfaceVariant.copy(alpha = 0.12f),
    onSecondaryContainer = RekoviColors.OnSurfaceVariant,
    
    tertiary = RekoviColors.Info,
    onTertiary = Color.White,
    tertiaryContainer = RekoviColors.Info.copy(alpha = 0.12f),
    onTertiaryContainer = RekoviColors.Info,
    
    error = RekoviColors.Error,
    onError = Color.White,
    errorContainer = RekoviColors.Error.copy(alpha = 0.12f),
    onErrorContainer = RekoviColors.Error,
    
    background = RekoviColors.Background,
    onBackground = RekoviColors.OnBackground,
    
    surface = RekoviColors.Surface,
    onSurface = RekoviColors.OnSurface,
    surfaceVariant = RekoviColors.SurfaceVariant,
    onSurfaceVariant = RekoviColors.OnSurfaceVariant,
    
    outline = RekoviColors.OnSurfaceVariant.copy(alpha = 0.3f),
    outlineVariant = RekoviColors.OnSurfaceVariant.copy(alpha = 0.1f),
)

// Esquema de cores escuro
private val DarkColorScheme = darkColorScheme(
    primary = RekoviColors.PrimaryLight,
    onPrimary = Color.Black,
    primaryContainer = RekoviColors.Primary,
    onPrimaryContainer = Color.White,
    
    secondary = Color(0xFF94A3B8),
    onSecondary = Color(0xFF1E293B),
    secondaryContainer = Color(0xFF334155),
    onSecondaryContainer = Color(0xFFE2E8F0),
    
    tertiary = Color(0xFF60A5FA),
    onTertiary = Color(0xFF1E293B),
    tertiaryContainer = Color(0xFF1E40AF),
    onTertiaryContainer = Color.White,
    
    error = Color(0xFFF87171),
    onError = Color(0xFF1E293B),
    errorContainer = Color(0xFFDC2626),
    onErrorContainer = Color.White,
    
    background = Color(0xFF0A0A0A),
    onBackground = Color(0xFFEDEDED),
    
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFEDEDED),
    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = Color(0xFFBBBBBB),
    
    outline = Color(0xFF6B7280),
    outlineVariant = Color(0xFF374151),
)

@Composable
fun RekoviTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = RekoviTypography,
        shapes = RekoviShapes,
        content = content
    )
}