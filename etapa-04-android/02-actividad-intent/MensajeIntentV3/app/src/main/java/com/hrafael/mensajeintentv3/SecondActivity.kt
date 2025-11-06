package com.hrafael.mensajeintentv3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.hrafael.mensajeintentv3.ui.theme.MensajeIntentV3Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nombre = intent.getStringExtra("nombre") ?: "(sin nombre)"
        val correo = intent.getStringExtra("correo") ?: "(sin correo)"

        setContent {
            MensajeIntentV3Theme {
                SecondScreen(nombre, correo) {
                    val data = Intent().apply {
                        putExtra("respuesta", "Datos de $nombre confirmados.")
                    }
                    setResult(Activity.RESULT_OK, data)
                    finish()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(nombre: String, correo: String, onConfirm: () -> Unit) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Actividad 2") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nombre $nombre", style = MaterialTheme.typography.headlineSmall)
            Text("Correo $correo", style = MaterialTheme.typography.headlineSmall)
            Button(onClick = onConfirm) {
                Text("Confirmar y regresar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    MensajeIntentV3Theme {
        SecondScreen("Harold", "prueba@correo.com", onConfirm = {})
    }
}
