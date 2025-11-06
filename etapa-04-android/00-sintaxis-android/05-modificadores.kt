package com.example.animacionescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimacionesComposeDemo()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimacionesComposeDemo() {
    var visible by remember { mutableStateOf(true) }
    var expand by remember { mutableStateOf(false) }
    var screen by remember { mutableStateOf("A") }
    val scope = rememberCoroutineScope()

    // 🔹 1. Animar color y tamaño con animate*AsState
    val color by animateColorAsState(
        targetValue = if (expand) Color(0xFF64B5F6) else Color(0xFF81C784),
        animationSpec = tween(800)
    )
    val size by animateDpAsState(
        targetValue = if (expand) 120.dp else 60.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Animaciones Compose") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { expand = !expand }) {
                Icon(Icons.Default.Refresh, contentDescription = "Animar")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Ejemplos de animaciones", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)

            // 🔸 1. Animación de color y tamaño
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color, CircleShape)
            )

            // 🔸 2. Animación de visibilidad
            Button(onClick = { visible = !visible }) {
                Text(if (visible) "Ocultar" else "Mostrar")
            }

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween(500)) + expandVertically(),
                exit = fadeOut(animationSpec = tween(500)) + shrinkVertically()
            ) {
                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color(0xFFFFB74D))
                )
            }

            // 🔸 3. Transición entre pantallas con Crossfade
            Button(onClick = { screen = if (screen == "A") "B" else "A" }) {
                Text("Cambiar pantalla")
            }

            Crossfade(targetState = screen) { target ->
                when (target) {
                    "A" -> Box(
                        Modifier
                            .size(80.dp)
                            .background(Color(0xFF9575CD))
                    )
                    "B" -> Box(
                        Modifier
                            .size(80.dp)
                            .background(Color(0xFF4DB6AC))
                    )
                }
            }

            // 🔸 4. Animación continua con InfiniteTransition
            val infiniteTransition = rememberInfiniteTransition()
            val rotacion by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            )

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .rotate(rotacion)
                    .background(Color(0xFFEF5350), CircleShape)
            )

            // 🔸 5. Animación controlada con Animatable
            val offset = remember { Animatable(0f) }
            Button(onClick = {
                scope.launch {
                    offset.animateTo(
                        targetValue = if (offset.value == 0f) 300f else 0f,
                        animationSpec = tween(800)
                    )
                }
            }) { Text("Mover círculo") }

            Box(
                modifier = Modifier
                    .offset(x = offset.value.dp)
                    .size(50.dp)
                    .background(Color(0xFF42A5F5), CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimacionesComposePreview() {
    AnimacionesComposeDemo()
}
