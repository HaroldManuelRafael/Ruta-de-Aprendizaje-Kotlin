package com.hrafael.mensajeintentv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.mensajeintentv2.ui.theme.MensajeIntentV2Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nombre = intent.getStringExtra("nombre") ?: "(No hay nombre)"
        val edad = intent.getStringExtra("edad") ?: "0"
        val correo = intent.getStringExtra("correo") ?: "(No hay correo)"

        setContent {
            MensajeIntentV2Theme {
                MostrarMensajeScreen(nombre, edad.toInt(), correo)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MostrarMensajeScreen(nombre: String, edad: Int, correo: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Actividad 2") })
        }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Nombres:",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = nombre,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Edad:",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = edad.toString(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Correo:",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = correo,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MostrarMensajePreview() {
    MensajeIntentV2Theme {
        MostrarMensajeScreen("Harold", 15, "hrafael@correo.com")
    }
}