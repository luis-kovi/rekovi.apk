package com.rekovi.taskmanager.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.rekovi.taskmanager.presentation.theme.RekoviColors
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun AnimatedBackground(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "background_animation")
    
    // Animação para movimento das formas
    val animationProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(20000),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation_animation"
    )
    
    // Animação para pulsação
    val pulseAnimation by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_animation"
    )
    
    // Animação para translação
    val translateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "translate_animation"
    )

    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        // Fundo gradiente
        val gradient = Brush.linearGradient(
            colors = listOf(
                RekoviColors.Background,
                RekoviColors.SurfaceVariant.copy(alpha = 0.6f),
                RekoviColors.Primary.copy(alpha = 0.08f)
            ),
            start = Offset.Zero,
            end = Offset(size.width, size.height)
        )
        
        drawRect(
            brush = gradient,
            size = size
        )
        
        // Desenhar carros estilizados em movimento
        drawMovingCars(
            animationProgress = animationProgress,
            translateOffset = translateAnimation
        )
        
        // Desenhar formas abstratas
        drawAbstractShapes(
            animationProgress = animationProgress,
            pulseScale = pulseAnimation
        )
    }
}

private fun DrawScope.drawMovingCars(
    animationProgress: Float,
    translateOffset: Float
) {
    val carColor = RekoviColors.Primary.copy(alpha = 0.1f)
    val carSize = 60.dp.toPx()
    
    // Carro 1 - movimento horizontal
    translate(
        left = (translateOffset * 2f) % (size.width + carSize) - carSize,
        top = size.height * 0.3f
    ) {
        drawCar(carColor, carSize)
    }
    
    // Carro 2 - movimento diagonal
    translate(
        left = (translateOffset * 1.5f) % (size.width + carSize) - carSize,
        top = size.height * 0.7f + sin(animationProgress * 0.02f) * 30f
    ) {
        drawCar(carColor.copy(alpha = 0.08f), carSize * 0.8f)
    }
}

private fun DrawScope.drawCar(color: Color, carSize: Float) {
    val path = Path().apply {
        // Corpo do carro
        moveTo(carSize * 0.1f, carSize * 0.7f)
        lineTo(carSize * 0.2f, carSize * 0.4f)
        lineTo(carSize * 0.8f, carSize * 0.4f)
        lineTo(carSize * 0.9f, carSize * 0.7f)
        lineTo(carSize * 0.9f, carSize * 0.8f)
        lineTo(carSize * 0.1f, carSize * 0.8f)
        close()
    }
    
    drawPath(path = path, color = color)
    
    // Rodas
    drawCircle(
        color = color,
        radius = carSize * 0.08f,
        center = Offset(carSize * 0.25f, carSize * 0.85f)
    )
    drawCircle(
        color = color,
        radius = carSize * 0.08f,
        center = Offset(carSize * 0.75f, carSize * 0.85f)
    )
}

private fun DrawScope.drawAbstractShapes(
    animationProgress: Float,
    pulseScale: Float
) {
    val shapeColor = RekoviColors.Primary.copy(alpha = 0.05f)
    
    // Forma circular em movimento
    rotate(animationProgress) {
        scale(pulseScale) {
            drawCircle(
                color = shapeColor,
                radius = 80.dp.toPx(),
                center = Offset(size.width * 0.2f, size.height * 0.2f)
            )
        }
    }
    
    // Forma oval
    rotate(-animationProgress * 0.5f) {
        scale(pulseScale * 0.8f) {
            drawOval(
                color = shapeColor.copy(alpha = 0.03f),
                topLeft = Offset(size.width * 0.7f, size.height * 0.1f),
                size = Size(120.dp.toPx(), 200.dp.toPx())
            )
        }
    }
    
    // Formas geométricas menores
    repeat(3) { index ->
        val angle = animationProgress + (index * 120f)
        val radius = 50.dp.toPx() + (index * 20.dp.toPx())
        val x = size.width * 0.8f + cos(Math.toRadians(angle.toDouble())).toFloat() * radius
        val y = size.height * 0.8f + sin(Math.toRadians(angle.toDouble())).toFloat() * radius
        
        drawCircle(
            color = shapeColor.copy(alpha = 0.04f),
            radius = (10 + index * 5).dp.toPx() * pulseScale,
            center = Offset(x, y)
        )
    }
}
