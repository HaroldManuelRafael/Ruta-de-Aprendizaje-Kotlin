package com.example.navegacioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionComposeDemo()
        }
    }
}

@Composable
fun NavegacionComposeDemo() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Navegación Compose") })
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            // Pantalla principal
            composable("home") { PantallaInicio(navController) }

            // Pantalla perfil sin parámetros
            composable("perfil") { PantallaPerfil(navController) }

            // Pantalla detalle con parámetro
            composable(
                route = "detalle/{nombre}",
                arguments = listOf(navArgument("nombre") { type = NavType.StringType })
            ) { backStackEntry ->
                val nombre = backStackEntry.arguments?.getString("nombre") ?: "Desconocido"
                PantallaDetalle(navController, nombre)
            }
        }
    }
}

// 🏠 Pantalla 1: Inicio
@Composable
fun PantallaInicio(navController: NavController) {
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Inicio", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Escribe tu nombre:")
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier
                .background(Color(0xFFE0E0E0))
                .padding(8.dp)
                .fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (nombre.isNotBlank()) {
                    navController.navigate("detalle/$nombre")
                }
            }
        ) { Text("Ir al detalle") }
    }
}

// 👤 Pantalla 2: Perfil
@Composable
fun PantallaPerfil(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Perfil de usuario", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text("Esta pantalla podría mostrar información del usuario o configuración.")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Volver")
        }
    }
}

// 📄 Pantalla 3: Detalle con parámetro
@Composable
fun PantallaDetalle(navController: NavController, nombre: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla Detalle", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Hola, $nombre 👋", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Regresar al inicio")
        }
    }
}

// ⚓ Barra inferior de navegación
@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") },
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = currentRoute == "perfil",
            onClick = { navController.navigate("perfil") }
        )
    }
}

// 🧭 Función auxiliar para conocer la ruta actual
@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview(showBackground = true)
@Composable
fun NavegacionComposePreview() {
    NavegacionComposeDemo()
}
