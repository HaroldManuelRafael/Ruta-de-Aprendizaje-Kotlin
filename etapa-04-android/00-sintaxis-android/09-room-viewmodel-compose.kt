package com.example.roomviewmodelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import androidx.room.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

// 🚀 1. ENTIDAD (tabla)
@Entity(tableName = "tareas")
data class Tarea(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String
)

// 🧩 2. DAO (acceso a datos)
@Dao
interface TareaDao {
    @Query("SELECT * FROM tareas ORDER BY id DESC")
    fun obtenerTareas(): Flow<List<Tarea>>

    @Insert
    suspend fun insertar(tarea: Tarea)

    @Delete
    suspend fun eliminar(tarea: Tarea)
}

// 🧱 3. BASE DE DATOS
@Database(entities = [Tarea::class], version = 1)
abstract class TareaDatabase : RoomDatabase() {
    abstract fun tareaDao(): TareaDao

    companion object {
        @Volatile private var INSTANCE: TareaDatabase? = null

        fun getDatabase(context: android.content.Context): TareaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TareaDatabase::class.java,
                    "tareas_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

// 🧠 4. REPOSITORIO
class TareaRepository(private val dao: TareaDao) {
    val tareas: Flow<List<Tarea>> = dao.obtenerTareas()

    suspend fun agregarTarea(titulo: String) {
        if (titulo.isNotBlank()) dao.insertar(Tarea(titulo = titulo))
    }

    suspend fun eliminarTarea(tarea: Tarea) {
        dao.eliminar(tarea)
    }
}

// 🧩 5. VIEWMODEL
class TareaViewModel(private val repository: TareaRepository) : ViewModel() {
    val tareas = repository.tareas.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun agregar(titulo: String) {
        viewModelScope.launch { repository.agregarTarea(titulo) }
    }

    fun eliminar(tarea: Tarea) {
        viewModelScope.launch { repository.eliminarTarea(tarea) }
    }
}

class TareaViewModelFactory(private val repository: TareaRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TareaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TareaViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconocido")
    }
}

// 🎨 6. UI COMPOSE
@Composable
fun TareasApp(viewModel: TareaViewModel) {
    val listaTareas by viewModel.tareas.collectAsState()

    var texto by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("🗒️ Tareas Compose") })
        },
        containerColor = Color(0xFFF5F5F5)
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Campo de texto + botón
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = texto,
                    onValueChange = { texto = it },
                    label = { Text("Nueva tarea") },
                    modifier = Modifier.weight(1f)
                )
                Button(onClick = {
                    viewModel.agregar(texto)
                    texto = ""
                }) { Text("Agregar") }
            }

            // Lista de tareas
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(listaTareas) { tarea ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(tarea.titulo, fontWeight = FontWeight.Medium)
                            IconButton(onClick = { viewModel.eliminar(tarea) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                            }
                        }
                    }
                }
            }

            if (listaTareas.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay tareas aún 💤", color = Color.Gray)
                }
            }
        }
    }
}

// 🚀 7. ACTIVITY PRINCIPAL
class RoomComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear instancia de base de datos y repositorio
        val database = TareaDatabase.getDatabase(this)
        val repository = TareaRepository(database.tareaDao())
        val factory = TareaViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[TareaViewModel::class.java]

        setContent {
            TareasApp(viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TareasAppPreview() {
    val fakeRepo = TareaRepositoryFake()
    val fakeVM = TareaViewModel(fakeRepo)
    TareasApp(fakeVM)
}

// 🔹 Simulación de repositorio para preview
class TareaRepositoryFake : TareaRepository(
    object : TareaDao {
        override fun obtenerTareas(): Flow<List<Tarea>> =
            flowOf(listOf(Tarea(1, "Ejemplo 1"), Tarea(2, "Ejemplo 2")))
        override suspend fun insertar(tarea: Tarea) {}
        override suspend fun eliminar(tarea: Tarea) {}
    }
)
