package com.hrafael.lazycolumninteractivo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.lazycolumninteractivo.ui.theme.LazyColumnInteractivoTheme

data class Fruta(val nombre: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnInteractivoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaDeFrutasInteractiva()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeFrutasInteractiva() {
    var nuevaFruta by remember { mutableStateOf(TextFieldValue("")) }
    val frutas = remember { mutableStateListOf("Manzana", "Banana", "Naranja", "Pera", "Uva") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Frutas Interactivas") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = nuevaFruta,
                    onValueChange = { nuevaFruta = it },
                    label = { Text("Agregar fruta") },
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {
                        val texto = nuevaFruta.text.trim()
                        if (texto.isNotEmpty()) {
                            frutas.add(texto)
                            nuevaFruta = TextFieldValue("")
                        }
                    }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar frutas")
                }
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(frutas, key = { it }) { fruta ->
                    FrutaItem(
                        nombre = fruta,
                        onEliminar = { frutas.remove(fruta) }
                    )
                }
            }
        }

    }
}

@Composable
fun FrutaItem(nombre: String, onEliminar: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(nombre, style = MaterialTheme.typography.titleMedium)
            IconButton(onClick = onEliminar) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar fruta")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListaDeFrutasInteractiva() {
    LazyColumnInteractivoTheme {
        ListaDeFrutasInteractiva()
    }
}