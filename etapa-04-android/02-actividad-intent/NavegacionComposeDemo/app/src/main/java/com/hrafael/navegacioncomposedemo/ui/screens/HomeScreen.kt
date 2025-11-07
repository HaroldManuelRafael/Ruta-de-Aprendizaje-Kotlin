package com.hrafael.navegacioncomposedemo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.navegacioncomposedemo.navigation.Route
import com.hrafael.navegacioncomposedemo.ui.theme.NavegacionComposeDemoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onOpenDetail: (Int, String?) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenSettings: (Int, String) -> Unit
) {
    var idText by remember { mutableStateOf("7") }
    var name by remember { mutableStateOf("Harold") }

    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Home") }) }) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                idText,
                { idText = it },
                label = { Text("ID (Int)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                name,
                { name = it },
                label = { Text("Nombre (opcional)") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val id = idText.toIntOrNull() ?: 0
                    onOpenDetail(id, name.ifBlank { null })
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Abrir Detail") }

            Button(
                onClick = { onOpenDetail(99, null) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text("Abrir Detail sin nombre")
            }

            Button(
                onClick = { onOpenProfile() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text("Ir al Perfil")
            }

            Button(
                onClick = {
                    onOpenSettings(101, "notificaciones")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir a Configuración de Perfil")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NavegacionComposeDemoTheme {
        HomeScreen(onOpenDetail = { _, _ -> }, onOpenProfile = {}, onOpenSettings = { _, _ -> })
    }
}