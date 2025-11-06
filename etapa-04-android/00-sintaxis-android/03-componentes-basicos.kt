package com.example.componentesbasicos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

// 🚀 Punto de entrada de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llamamos a la UI principal
            ComponentesBasicosDemo()
        }
    }
}

// 🎨 UI principal que agrupa los componentes
@Composable
fun ComponentesBasicosDemo() {
    // Estado para el campo de texto
    var nombre by remember { mutableStateOf("") }

    // Contenedor principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🧱 1. Texto simple
        Text(
            text = "Componentes básicos de Compose",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.primary
        )

        // 🧱 2. Campo de texto (TextField)
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre") }
        )

        // 🧱 3. Botón
        Button(
            onClick = { /* Acción al presionar */ },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(text = "Enviar")
        }

        // 🧱 4. Mostrar texto dinámico según el input
        if (nombre.isNotEmpty()) {
            Text(
                text = "Hola, $nombre 👋",
                fontSize = 18.sp,
                color = Color.Gray
            )
        }

        // 🧱 5. Fila con elementos (Row)
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Fila de botones:")
            Button(onClick = {}) { Text("A") }
            Button(onClick = {}) { Text("B") }
        }

        // 🧱 6. Imagen (si tienes un recurso drawable)
        // Descomenta si tienes una imagen en res/drawable
        /*
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo"
        )
        */
    }
}

// 👀 Vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun ComponentesBasicosDemoPreview() {
    ComponentesBasicosDemo()
}
