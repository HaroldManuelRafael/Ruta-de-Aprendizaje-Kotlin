package com.hrafael.roombasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.hrafael.roombasico.data.database.AppDatabase
import com.hrafael.roombasico.data.entity.Persona
import com.hrafael.roombasico.ui.theme.RoomBasicoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "personas_db"
        ).build()

        setContent {
            RoomBasicoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PersonaScreen(db)
                }
            }
        }
    }
}

@Composable
fun PersonaScreen(db: AppDatabase) {
    val scope = rememberCoroutineScope()
    val dao = db.personaDao()

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    val personas by dao.obtenerPersonas().collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                scope.launch {
                    if (nombre.isNotBlank() && edad.isNotBlank()) {
                        dao.insertar(Persona(nombre = nombre, edad = edad.toInt()))
                        nombre = ""
                        edad = ""
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Persona")
        }

        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(personas) { persona ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text("ID: ${persona.id}")
                        Text("Nombre: ${persona.nombre}")
                        Text("Edad: ${persona.edad}")
                    }
                }
            }
        }
    }
}