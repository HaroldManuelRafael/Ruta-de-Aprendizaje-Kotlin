package com.example.componentesavanzados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentesAvanzadosDemo()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentesAvanzadosDemo() {
    // Estado del Drawer lateral
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Estado de pestañas
    var selectedTab by remember { mutableStateOf(0) }

    // Estado de animación
    var expand by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    "Menú principal",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold
                )
                NavigationDrawerItem(
                    label = { Text("Inicio") },
                    selected = false,
                    onClick = { /* Navegar */ },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) }
                )
                NavigationDrawerItem(
                    label = { Text("Perfil") },
                    selected = false,
                    onClick = { /* Navegar */ },
                    icon = { Icon(Icons.Default.Person, contentDescription = null) }
                )
            }
        }
    ) {
        // 🔹 SCaffold: estructura principal con AppBar + BottomBar
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Compose Avanzado") },
                    navigationIcon = {
                        IconButton(onClick = {
                            if (drawerState.isClosed) {
                                scope.launch { drawerState.open() }
                            } else {
                                scope.launch { drawerState.close() }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Notifications, contentDescription = "Notif")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Inicio") },
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Search, contentDescription = null) },
                        label = { Text("Buscar") },
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = null) },
                        label = { Text("Perfil") },
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 }
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { expand = !expand }) {
                    Icon(Icons.Default.Add, contentDescription = "FAB")
                }
            }
        ) { innerPadding ->
            // Contenido principal
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Pestañas y animación básica",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                // 🔸 Tabs
                TabRow(selectedTabIndex = selectedTab) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = { Text("Inicio") }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        text = { Text("Favoritos") }
                    )
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        text = { Text("Perfil") }
                    )
                }

                // 🔸 Contenido de pestaña
                when (selectedTab) {
                    0 -> ContenidoInicio()
                    1 -> ContenidoFavoritos()
                    2 -> ContenidoPerfil()
                }

                // 🔸 Animación simple (altura cambia con botón FAB)
                val boxHeight by animateDpAsState(
                    targetValue = if (expand) 150.dp else 60.dp,
                    animationSpec = tween(durationMillis = 500)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(boxHeight)
                        .background(Color(0xFFBBDEFB)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(if (expand) "Expandido" else "Compacto")
                }
            }
        }
    }
}

// 🧱 Contenido por pestaña
@Composable
fun ContenidoInicio() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(10) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Elemento $it",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ContenidoFavoritos() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("❤️ Lista de favoritos vacía por ahora.")
    }
}

@Composable
fun ContenidoPerfil() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("👤 Perfil del usuario", fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentesAvanzadosPreview() {
    ComponentesAvanzadosDemo()
}
