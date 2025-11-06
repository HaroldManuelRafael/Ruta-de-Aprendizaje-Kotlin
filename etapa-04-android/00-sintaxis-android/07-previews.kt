// 07-previews.kt
// 👁️ Previews en Jetpack Compose
//
// Las previews permiten visualizar composables en Android Studio sin ejecutar la app.
// Puedes tener múltiples vistas previas con diferentes configuraciones.
//

package com.example.previewscompose

import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal()
        }
    }
}

// 🧱 Composable principal
@Composable
fun PantallaPrincipal() {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Vista Principal") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F4F6))
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hola Jetpack Compose 👋",
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Button(onClick = {}) { Text("Presióname") }
            CajaDeColor()
        }
    }
}

// 🎨 Componente secundario
@Composable
fun CajaDeColor() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(MaterialTheme.colorScheme.tertiary),
        contentAlignment = Alignment.Center
    ) {
        Text("Caja", color = Color.White, fontSize = 18.sp)
    }
}

// 👁️ 1️⃣ Vista previa simple
@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    PantallaPrincipal()
}

// 👁️ 2️⃣ Vista previa con modo oscuro
@Preview(
    name = "Modo oscuro",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PantallaPrincipalDarkPreview() {
    PantallaPrincipal()
}

// 👁️ 3️⃣ Vista previa de componente individual
@Preview(name = "Caja individual", showBackground = true)
@Composable
fun CajaDeColorPreview() {
    CajaDeColor()
}

// 👁️ 4️⃣ Vista previa en dispositivo específico
@Preview(
    name = "Pixel 7 Preview",
    device = Devices.PIXEL_7,
    showSystemUi = true
)
@Composable
fun PantallaCompletaPreview() {
    PantallaPrincipal()
}

// 👁️ 5️⃣ Varias vistas previas en distintas configuraciones
@Preview(name = "Compacto", widthDp = 200, heightDp = 400)
@Preview(name = "Tablet", widthDp = 800, heightDp = 1280)
@Composable
fun PantallaMultiPreview() {
    PantallaPrincipal()
}
