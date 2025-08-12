package com.rekovi.taskmanager.presentation.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import com.rekovi.taskmanager.domain.model.Card
import com.rekovi.taskmanager.presentation.components.icons.RekoviIcons
import com.rekovi.taskmanager.presentation.theme.RekoviColors
import com.rekovi.taskmanager.presentation.theme.RekoviCustomShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen(
    card: Card,
    onBack: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Detalhes", "Ações")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        RekoviColors.Background,
                        RekoviColors.SurfaceVariant
                    )
                )
            )
    ) {
        // Header com botão voltar
        TaskDetailHeader(
            title = card.placa,
            onBack = onBack
        )

        // Tab Row
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = RekoviColors.Surface,
            contentColor = RekoviColors.Primary,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = RekoviColors.Primary,
                    height = 3.dp
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = if (selectedTab == index) FontWeight.SemiBold else FontWeight.Medium
                            )
                        )
                    }
                )
            }
        }

        // Content based on selected tab
        when (selectedTab) {
            0 -> TaskDetailsTab(card = card)
            1 -> TaskActionsTab(card = card)
        }
    }
}

@Composable
private fun TaskDetailHeader(
    title: String,
    onBack: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = RekoviColors.Surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RekoviCustomShapes.inputField
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = RekoviColors.Primary.copy(alpha = 0.1f),
                        shape = RekoviCustomShapes.inputField
                    )
            ) {
                Icon(
                    imageVector = RekoviIcons.ArrowBack,
                    contentDescription = "Voltar",
                    tint = RekoviColors.Primary
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Detalhes da Tarefa",
                    style = MaterialTheme.typography.titleMedium,
                    color = RekoviColors.OnSurfaceVariant
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = RekoviColors.OnSurface
                )
            }
        }
    }
}

@Composable
private fun TaskDetailsTab(card: Card) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Status Card
        InfoCard(
            title = "Status Atual",
            icon = RekoviIcons.Info
        ) {
            StatusBadge(
                status = card.faseAtual,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Vehicle Info Card
        InfoCard(
            title = "Informações do Veículo",
            icon = RekoviIcons.Car
        ) {
            VehicleInfoContent(card)
        }

        // Client Info Card
        InfoCard(
            title = "Informações do Cliente",
            icon = RekoviIcons.User
        ) {
            ClientInfoContent(card)
        }

        // Service Provider Card
        InfoCard(
            title = "Prestador de Serviço",
            icon = RekoviIcons.Building
        ) {
            ServiceProviderContent(card)
        }
    }
}

@Composable
private fun TaskActionsTab(card: Card) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // WebView Card
        InfoCard(
            title = "Ações Disponíveis",
            icon = RekoviIcons.Actions
        ) {
            // WebView integrated
            if (card.urlPublica?.isNotBlank() == true) {
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            webViewClient = WebViewClient()
                            settings.javaScriptEnabled = true
                            settings.domStorageEnabled = true
                            loadUrl(card.urlPublica!!)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .clip(RekoviCustomShapes.taskCard)
                        .background(RekoviColors.SurfaceVariant)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(
                            color = RekoviColors.SurfaceVariant,
                            shape = RekoviCustomShapes.taskCard
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = RekoviIcons.ExternalLink,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = RekoviColors.OnSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Nenhuma ação disponível",
                            style = MaterialTheme.typography.bodyMedium,
                            color = RekoviColors.OnSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoCard(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = RekoviColors.Surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RekoviCustomShapes.taskCard
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = RekoviColors.Primary
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = RekoviColors.OnSurface
                )
            }
            content()
        }
    }
}

@Composable
private fun StatusBadge(
    status: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = RekoviColors.Primary.copy(alpha = 0.1f),
                shape = RekoviCustomShapes.statusBadge
            )
            .border(
                width = 1.dp,
                color = RekoviColors.Primary.copy(alpha = 0.3f),
                shape = RekoviCustomShapes.statusBadge
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = status,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = RekoviColors.Primary
        )
    }
}

@Composable
private fun VehicleInfoContent(card: Card) {
    val context = LocalContext.current
    
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoRow(
            label = "Placa",
            value = card.placa,
            icon = RekoviIcons.Car
        )
        InfoRow(
            label = "Modelo",
            value = card.modelo,
            icon = RekoviIcons.Car
        )
        InfoRow(
            label = "Localização",
            value = card.localizacao,
            icon = RekoviIcons.Location,
            isClickable = true,
            onClick = {
                // Open Google Maps
                val gmmIntentUri = Uri.parse("geo:0,0?q=${card.localizacao}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }
        )
        InfoRow(
            label = "Local de Entrega",
            value = card.cidadeOrigem,
            icon = RekoviIcons.Location
        )
    }
}

@Composable
private fun ClientInfoContent(card: Card) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoRow(
            label = "Nome",
            value = card.nomeCliente,
            icon = RekoviIcons.User
        )
        InfoRow(
            label = "Telefone Principal",
            value = card.telefoneCliente,
            icon = RekoviIcons.Phone
        )
        if (card.telefoneOpcional?.isNotBlank() == true) {
            InfoRow(
                label = "Telefone Opcional",
                value = card.telefoneOpcional ?: "",
                icon = RekoviIcons.Phone
            )
        }
        InfoRow(
            label = "Endereço",
            value = card.enderecoCliente,
            icon = RekoviIcons.Location
        )
    }
}

@Composable
private fun ServiceProviderContent(card: Card) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoRow(
            label = "Empresa Responsável",
            value = card.empresaResponsavel ?: "Não informado",
            icon = RekoviIcons.Building
        )
        InfoRow(
            label = "Chofer",
            value = card.emailChofer ?: "Não informado",
            icon = RekoviIcons.Truck
        )
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String,
    icon: ImageVector,
    isClickable: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .run {
                if (isClickable && onClick != null) {
                    clickable { onClick() }
                        .background(
                            color = RekoviColors.Primary.copy(alpha = 0.05f),
                            shape = RekoviCustomShapes.inputField
                        )
                        .padding(12.dp)
                } else {
                    padding(vertical = 4.dp)
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = if (isClickable) RekoviColors.Primary else RekoviColors.OnSurfaceVariant
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = RekoviColors.OnSurfaceVariant
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = if (isClickable) RekoviColors.Primary else RekoviColors.OnSurface
            )
        }
        if (isClickable) {
            Icon(
                imageVector = RekoviIcons.ExternalLink,
                contentDescription = "Abrir",
                modifier = Modifier.size(16.dp),
                tint = RekoviColors.Primary
            )
        }
    }
}
