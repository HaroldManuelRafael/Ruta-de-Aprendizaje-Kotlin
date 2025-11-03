# ⚙️ Etapa 03 – Programación Funcional y Asincronía

En esta etapa aprenderás a usar **funciones como datos**, a trabajar con **colecciones de forma funcional**  
y a introducirte en el manejo de **asincronía con hilos y coroutines**.

---

## 🎯 Objetivo general
Dominar los principios de la **programación funcional** en Kotlin,  
entendiendo cómo combinar funciones, expresiones lambda, y estructuras inmutables  
para escribir código más limpio, seguro y reutilizable.

---

## 🧩 Temas y ejercicios

| Archivo | Tema | Descripción |
|----------|------|-------------|
| `01-funciones-orden-superior.kt` | Funciones de orden superior | Funciones que reciben o devuelven otras funciones. |
| `02-lambdas-avanzadas.kt` | Lambdas y trailing syntax | Cómo definir funciones anónimas y pasarlas como argumentos. |
| `03-colecciones-funcionales.kt` | Map, Filter, Reduce | Operaciones funcionales sobre listas y conjuntos. |
| `04-expresiones.kt` | Expresiones y retornos | Diferencia entre sentencias y expresiones. |
| `05-inmutabilidad.kt` | Listas inmutables | Ventajas de los datos inmutables. |
| `06-scope-functions.kt` | let, run, apply, also, with | Uso de funciones de alcance. |
| `07-threads.kt` | Multithreading | Crear y ejecutar tareas en paralelo. |
| `08-coroutines-basico.kt` | Introducción a Coroutines | Ejecución asincrónica con `launch`, `delay`, y `runBlocking`. |
| `09-coroutines-avanzado.kt` | Suspensión y async/await | Manejo estructurado de concurrencia. |
| `10-mini-proyecto-coroutines.kt` | Proyecto práctico | Simular un sistema concurrente (por ejemplo: descargas o tareas simultáneas). |

---

## ⚙️ Conceptos clave
- **Programación funcional** → funciones puras, sin efectos secundarios.  
- **Lambdas** → funciones anónimas que se pueden pasar como datos.  
- **Funciones de orden superior** → reciben o devuelven otras funciones.  
- **Inmutabilidad** → trabajar con estructuras de datos que no cambian.  
- **Hilos (`Thread`)** → ejecución paralela real.  
- **Coroutines** → asincronía ligera controlada por el compilador.  
- **Scope functions** → simplifican la escritura de bloques de inicialización y transformación.

---

## 🧠 Ejemplo de programación funcional

```kotlin
fun main() {
    val numeros = listOf(1, 2, 3, 4, 5)

    // Map transforma cada elemento
    val dobles = numeros.map { it * 2 }

    // Filter selecciona los pares
    val pares = dobles.filter { it % 2 == 0 }

    // Reduce suma todos los elementos
    val total = pares.reduce { acc, n -> acc + n }

    println("Total: $total")
}
```

---

## 🕹️ Ejemplo de coroutine

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("Tarea 1 completada")
    }
    launch {
        delay(500L)
        println("Tarea 2 completada")
    }
    println("Inicio")
}
```

---

## 🧭 Resultado de la etapa
Al finalizar esta etapa podrás:
- Usar **lambdas y funciones de orden superior** con soltura.  
- Manipular listas de forma **declarativa y elegante**.  
- Crear programas **concurrentes y asincrónicos** usando **threads** y **coroutines**.  
- Entender **cuándo usar asincronía** y cómo evitar bloqueos.

---

✍️ **Autor:** Harold Manuel Rafael Ñaupari  
🎓 Proyecto educativo – *Ruta de Aprendizaje Kotlin*
