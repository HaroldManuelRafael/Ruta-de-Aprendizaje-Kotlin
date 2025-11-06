# 📱 Proyecto: MensajeIntent (Comunicación entre Activities)

## 🎯 Objetivo
Aprender a **enviar y recibir datos entre Activities** en Android utilizando **Intents**, aplicando Jetpack Compose y Material 3 para el diseño moderno de las pantallas.

---

## 🧱 Estructura del proyecto

```
02-actividad-intent/
└── MensajeIntent/
    ├── MainActivity.kt
    ├── SecondActivity.kt
    ├── AndroidManifest.xml
    ├── ui/theme/
    └── build.gradle
```

---

## ⚙️ Descripción general

La aplicación contiene **dos pantallas (Activities)**:

| Pantalla | Descripción |
|-----------|--------------|
| **MainActivity** | Permite escribir un mensaje en un campo de texto y enviarlo a otra pantalla mediante un `Intent`. |
| **SecondActivity** | Recibe el mensaje y lo muestra centrado en pantalla. |

---

## 🧩 Código principal

### 🪜 `MainActivity.kt`

```kotlin
package com.hrafael.mensajeintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.hrafael.mensajeintent.ui.theme.MensajeIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MensajeIntentTheme {
                EnviarMensajeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnviarMensajeScreen() {
    var mensaje by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Actividad 1") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = mensaje,
                onValueChange = { mensaje = it },
                label = { Text("Escribe un mensaje") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra("mensaje", mensaje)
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar mensaje ➡️")
            }
        }
    }
}
```

---

### 🪜 `SecondActivity.kt`

```kotlin
package com.hrafael.mensajeintent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.mensajeintent.ui.theme.MensajeIntentTheme

@OptIn(ExperimentalMaterial3Api::class)
class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mensaje = intent.getStringExtra("mensaje") ?: "(sin mensaje)"

        setContent {
            MensajeIntentTheme {
                MostrarMensajeScreen(mensaje)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MostrarMensajeScreen(mensaje: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Actividad 2") }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mensaje recibido:\n$mensaje",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MostrarMensajePreview() {
    MensajeIntentTheme {
        MostrarMensajeScreen("Mensaje de prueba desde Preview 🎉")
    }
}
```

---

## 🧠 Conceptos clave

| Concepto | Descripción |
|-----------|--------------|
| **Intent** | Objeto usado para iniciar otra Activity o app, y opcionalmente enviar datos. |
| **putExtra / getStringExtra** | Métodos para enviar y recibir datos entre Activities. |
| **LocalContext** | Permite acceder al contexto Android desde un Composable. |
| **Scaffold** | Estructura con barra superior, cuerpo y paddings automáticos. |
| **@OptIn(ExperimentalMaterial3Api::class)** | Habilita componentes experimentales de Material 3. |

---

## ⚠️ Errores comunes y soluciones

| Error | Causa | Solución |
|--------|--------|-----------|
| `@Composable invocations can only happen...` | Error de sintaxis en el `modifier` (mal escrito). | Asegurar `modifier = Modifier` correctamente. |
| `Type 'MutableState<String>' has no method 'setValue'` | Falta importar `getValue` y `setValue` de Compose. | Agregar `import androidx.compose.runtime.getValue` y `import androidx.compose.runtime.setValue`. |
| Preview vacía | No se agregó un Composable separado con `@Preview`. | Crear `MostrarMensajeScreen()` y un `@Preview`. |

---

## 🚀 Resultado esperado

**Actividad 1:**  
Campo de texto + botón “Enviar mensaje”.  

**Actividad 2:**  
Pantalla con texto centrado que muestra el mensaje recibido.  

📸 Ejemplo del resultado:  
```
Mensaje recibido:
saludos desde la primera ventana
```

---

## 📚 Próximo paso
> **Etapa siguiente:** `03-listview-recycler`  
> Aprenderás a mostrar listas de elementos usando `LazyColumn` (Compose) o `RecyclerView` (XML).
