# 📘 Etapa 00 — Sintaxis Android (Jetpack Compose)

Esta primera etapa enseña **los fundamentos de Jetpack Compose** y cómo se estructura una aplicación Android moderna usando **Kotlin**, **Material 3**, y el enfoque declarativo.

---

## 🎯 Objetivo general
Comprender cómo funciona la interfaz declarativa de Android, sus componentes, layouts, animaciones y navegación básica, antes de integrar lógica o persistencia de datos.

---

## 🧱 Estructura de archivos

| Archivo | Descripción |
|----------|--------------|
| **01-estructura-app-android.md** | Explica la estructura base de un proyecto Android: carpetas, AndroidManifest, Gradle y MainActivity. |
| **02-activity-compose.kt** | Crea la primera Activity con Jetpack Compose, mostrando texto y un botón. |
| **03-componentes-todos.kt** | Presenta los principales componentes visuales (Text, Button, TextField, Card, Listas, etc.). |
| **03b-componentes-avanzados.kt** | Incluye componentes estructurales como Scaffold, TopAppBar, NavigationBar, Drawer, Tabs y animaciones básicas. |
| **04-layouts-y-modificadores.kt** | Enseña cómo controlar tamaño, posición, espaciado, bordes, color y forma con `Modifier`. |
| **05-animaciones-compose.kt** | Introduce animaciones declarativas: visibilidad, movimiento, color, transición y animaciones infinitas. |
| **06-navegacion-compose.kt** | Muestra cómo navegar entre pantallas con `NavController`, `NavHost` y paso de parámetros. |
| **07-previews.kt** | Enseña a usar `@Preview` para visualizar composables en modo claro, oscuro, diferentes dispositivos y tamaños. |

---

## 🧩 Conceptos clave

- **Composable:** función que genera UI reactiva y declarativa.
- **Modifier:** controla tamaño, forma, espaciado, color y comportamiento.
- **State:** valores observables que redibujan la UI al cambiar.
- **Scaffold:** estructura base de pantallas con barra superior, FAB y barra inferior.
- **MaterialTheme:** define colores, tipografía y estilos globales.
- **Navigation Compose:** navegación basada en rutas, dentro de una sola Activity.
- **Preview:** permite probar componentes sin ejecutar la app.

---

## ⚙️ Requisitos previos

- Android Studio Flamingo o superior (recomendado: Ladybug+).
- SDK 34+ y Kotlin 1.9+.
- Familiaridad básica con Kotlin (variables, funciones, clases).
- Node opcional: VS Code puede usarse para revisión del código fuente.

---

## 🚀 Resultado esperado

Al finalizar esta etapa, dominarás:
1. La **estructura completa** de una app Jetpack Compose.
2. El **uso de los principales componentes visuales**.
3. El control de **layouts y modificadores**.
4. La creación de **animaciones básicas**.
5. La **navegación entre pantallas**.
6. La capacidad de **probar composables sin ejecutar la app**.

---

## 📚 Próxima etapa

> **Etapa 01 — Arquitectura y Estado (ViewModel + Room + Flow)**  
> En esta etapa aprenderás cómo manejar datos persistentes y estados usando `ViewModel`, `Room` y `Flow`, conectando lógica de negocio con la UI.

