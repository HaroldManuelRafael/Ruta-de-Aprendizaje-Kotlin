package com.hrafael.lazycolumncompose

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.lazycolumncompose.ui.theme.LazyColumnComposeTheme

data class Fruta(val nombre: String, val imagenRes: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaDeFrutasScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeFrutasScreen() {
    val frutas = listOf(
        Fruta("Manzana", android.R.drawable.ic_menu_gallery),
        Fruta("Banana", android.R.drawable.ic_menu_gallery),
        Fruta("Naranja", android.R.drawable.ic_menu_gallery),
        Fruta("Pera", android.R.drawable.ic_menu_gallery),
        Fruta("Uva", android.R.drawable.ic_menu_gallery),
        Fruta("Fresa", android.R.drawable.ic_menu_gallery),
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Lista de Frutas") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(frutas) { fruta ->
                ItemFruta(fruta)
            }
        }
    }
}

@Composable
fun ItemFruta(fruta: Fruta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = fruta.imagenRes),
                contentDescription = fruta.nombre,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = fruta.nombre,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewListaDeFrutas() {
    LazyColumnComposeTheme {
        ListaDeFrutasScreen()
    }
}