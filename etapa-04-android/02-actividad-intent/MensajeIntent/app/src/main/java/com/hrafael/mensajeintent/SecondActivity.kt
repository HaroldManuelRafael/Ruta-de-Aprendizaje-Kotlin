package com.hrafael.mensajeintent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hrafael.mensajeintent.ui.theme.MensajeIntentTheme

class SecondActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mensaje = intent.getStringExtra("mensaje") ?: "(sin mensaje)"

        setContent {
            MensajeIntentTheme {
                MostrarMensajeScreen(mensaje)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MostrarMensajeScreen(mensaje: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Actividad 2") }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mensaje recibido:\n$mensaje",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MostrarMensajePreview() {
    MensajeIntentTheme {
        MostrarMensajeScreen("Mensaje de prueba desde Preview")
    }
}
