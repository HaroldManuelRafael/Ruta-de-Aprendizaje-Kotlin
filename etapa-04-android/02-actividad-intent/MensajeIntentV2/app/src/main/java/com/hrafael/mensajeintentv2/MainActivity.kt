package com.hrafael.mensajeintentv2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.mensajeintentv2.ui.theme.MensajeIntentV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MensajeIntentV2Theme {
                EnviarMensajeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnviarMensajeScreen() {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Actividad 1"
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Escribe el nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Ingresa tu edad") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Ingresa correo") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("edad", edad)
                    intent.putExtra("correo", correo)
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar mensaje")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MensajeIntentV2Theme {
        EnviarMensajeScreen()
    }
}