package com.rekovi.taskmanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.rekovi.taskmanager.presentation.navigation.RekoviNavigation
import com.rekovi.taskmanager.presentation.theme.RekoviTheme
import com.rekovi.taskmanager.utils.DebugUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Imprimir SHA-1 no Logcat para configuração Google OAuth
        DebugUtils.logAppSigningInfo(this)
        
        setContent {
            RekoviTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RekoviNavigation()
                }
            }
        }
    }
}

