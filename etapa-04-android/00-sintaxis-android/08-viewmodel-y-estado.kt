package com.example.viewmodelyestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

// 🚀 Actividad principal
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorApp()
        }
    }
}

// 🧩 ViewModel: mantiene el estado aunque la pantalla rote o se recree
class ContadorViewModel : ViewModel() {
    // mutableStateOf convierte la variable en reactiva (redibuja la UI al cambiar)
    private val _contador = mutableStateOf(0)
    val contador: State<Int> = _contador

    fun incrementar() {
        _contador.value++
    }

    fun reiniciar() {
        _contador.value = 0
    }
}

// 🎨 Composable principal
@Composable
fun ContadorApp(viewModel: ContadorViewModel = viewModel()) {
    val contador by viewModel.contador // Observa el valor del ViewModel

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("ViewModel y Estado") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Contador:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(contador.toString(), fontSize = 36.sp, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { viewModel.incrementar() }) { Text("Sumar") }
                Button(onClick = { viewModel.reiniciar() }) { Text("Reiniciar") }
            }
        }
    }
}

// 🧱 Ejemplo sin ViewModel (usando rememberSaveable)
@Composable
fun ContadorRememberSaveable() {
    // Este contador se conserva incluso si la pantalla rota o se recrea
    var contador by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Contador local:", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(contador.toString(), fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { contador++ }) { Text("Sumar") }
    }
}

// 👁️ Previews
@Preview(showBackground = true)
@Composable
fun ContadorAppPreview() {
    ContadorApp()
}

@Preview(showBackground = true)
@Composable
fun ContadorRememberSaveablePreview() {
    ContadorRememberSaveable()
}
