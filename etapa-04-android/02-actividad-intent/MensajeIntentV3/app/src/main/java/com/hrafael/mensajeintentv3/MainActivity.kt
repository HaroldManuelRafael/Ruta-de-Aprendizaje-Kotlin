package com.hrafael.mensajeintentv3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.mensajeintentv3.ui.theme.MensajeIntentV3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MensajeIntentV3Theme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var respuesta by remember { mutableStateOf("") }

    val context = LocalContext.current

    // Launcher para recibir resultado desde la segunda Activity
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            respuesta = result.data?.getStringExtra("respuesta") ?: "(sin respuesta)"
        }
    }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Actividad 1") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("correo", correo)
                    launcher.launch(intent)
                },
                enabled = nombre.isNotBlank() && correo.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar a segunda Activity")
            }

            if (respuesta.isNotEmpty()){
                Text("Respuesta recibida: $respuesta")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MensajeIntentV3Theme {
        MainScreen()
    }
}