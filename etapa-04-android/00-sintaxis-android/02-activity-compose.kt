package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 🚀 MainActivity: punto de entrada de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent define la interfaz de usuario usando funciones composables
        setContent {
            // Llamamos a nuestra función composable principal
            MyFirstComposeApp()
        }
    }
}

// 🎨 Función composable principal
@Composable
fun MyFirstComposeApp() {
    // Surface es el contenedor principal que respeta el tema actual (Material3)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Contenido principal de la pantalla
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¡Hola desde Jetpack Compose!",
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Acción futura */ }) {
                Text("Haz clic aquí")
            }
        }
    }
}

// 👀 Vista previa del diseño en Android Studio
@Preview(showBackground = true)
@Composable
fun MyFirstComposeAppPreview() {
    MyFirstComposeApp()
}
