# 🎉 Proyecto: Cumpleaños App (Hello Android)

## 📱 Descripción general
Este es el **primer proyecto Android con Jetpack Compose**, desarrollado como parte de la ruta de aprendizaje en la etapa **01-hello-android**.  
El objetivo es construir una pequeña aplicación que muestre un mensaje de cumpleaños personalizado, aplicando los fundamentos de **Kotlin** y **Material 3**.

---

## 🎯 Objetivo
- Comprender el flujo básico de una aplicación Android con `ComponentActivity` y `setContent`.
- Aprender a crear y estructurar un **Composable**.
- Usar `MaterialTheme` y `Surface` para aplicar estilos modernos.
- Generar una vista previa con `@Preview` sin ejecutar la app.

---

## 🧩 Código principal

```kotlin
package com.hrafael.cumpleano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrafael.cumpleano.ui.theme.CumpleanoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CumpleanoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Harold")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Feliz cumpleaños, $name!",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Te desea tu primera app Android con Jetpack Compose",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CumpleanoTheme {
        Greeting("Harold")
    }
}
```

---

## 🧠 Conceptos clave

| Concepto | Descripción |
|-----------|--------------|
| **Composable** | Función que genera una parte de la UI de forma declarativa. |
| **Column / Spacer / Text** | Componentes básicos de diseño en Compose. |
| **Modifier** | Controla tamaño, espaciado, color, padding y alineación. |
| **Surface** | Crea un contenedor con fondo y estilo consistente. |
| **MaterialTheme** | Define colores, tipografía y estilos globales. |
| **@Preview** | Permite visualizar el composable directamente en Android Studio. |

---

## ⚙️ Requisitos
- Android Studio Ladybug o superior.
- SDK 34 o superior.
- Kotlin 1.9+.
- Conocimientos básicos de funciones y variables en Kotlin.

---

## 🧱 Estructura del proyecto

```
01-hello-android/
├── Cumpleano/
│   ├── MainActivity.kt
│   ├── ui/theme/
│   └── AndroidManifest.xml
└── notas.md
```

---

## 🚀 Resultado esperado

Al ejecutar la app, se mostrará:

```
¡Feliz cumpleaños, Harold!
Te desea tu primera app Android con Jetpack Compose
```

Centrado en pantalla, con estilos de Material Design 3.

---

## 💡 Extensiones opcionales
- Agregar un campo `TextField` para escribir el nombre.
- Incluir una imagen (`Image()`) de pastel o confeti.
- Aplicar animación de entrada con `AnimatedVisibility`.
- Usar `MaterialTheme.colorScheme` para personalizar colores.

---

## 📚 Próximo paso
> **Etapa siguiente:** `02-actividad-intent`  
> Aprenderás a navegar entre Activities y enviar datos con `Intent`.
