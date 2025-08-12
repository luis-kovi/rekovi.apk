package com.rekovi.taskmanager.presentation.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rekovi.taskmanager.R
import com.rekovi.taskmanager.domain.model.PreApprovedUser
import com.rekovi.taskmanager.domain.model.User
import com.rekovi.taskmanager.presentation.components.UserDropdown
import com.rekovi.taskmanager.presentation.theme.RekoviColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskHeader(
    user: User,
    preApprovedUser: PreApprovedUser,
    isUpdating: Boolean,
    onLogout: () -> Unit
) {
    // Header compacto e moderno
        Card(
        modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo da Rekovi no canto esquerdo
            AsyncImage(
                model = "https://i.ibb.co/d4kbJGGY/rekovi-identity-updated-1-removebg-preview.png",
                contentDescription = "Logo Rekovi",
                    modifier = Modifier
                    .size(40.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Indicador de carregamento
                if (isUpdating) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = RekoviColors.Primary,
                        strokeWidth = 2.dp
                    )
                }
                
                // Dropdown do usuário
                UserDropdown(
                    user = user,
                    preApprovedUser = preApprovedUser,
                    onLogout = onLogout
                )
            }
        }
    }


}

