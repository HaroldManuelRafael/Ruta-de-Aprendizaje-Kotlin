# 🧠 Etapa 01 — Fundamentos de Kotlin

Aprendizaje de la sintaxis base, estructuras de control, funciones, colecciones y manejo seguro de tipos.  
Esta etapa sienta las bases para avanzar a POO, programación funcional y proyectos reales con Kotlin.

---

## 📚 Contenidos vistos

| Nº | Ejercicio | Conceptos principales |
|----|------------|-----------------------|
| 1 | **descuento-calculadora.kt** | Variables, operadores aritméticos, lectura de datos (`readln`), `if/else`. |
| 2 | **validador-email.kt** | Expresiones regulares, funciones con retorno, condicionales. |
| 3 | **filtro-listas.kt** | Colecciones (`List`), lambdas (`map`, `filter`), `filterNotNull`. |
| 4 | **promedio-calificaciones.kt** | Listas mutables, bucles, validaciones, función `when`. |
| 5 | **contador-vocales.kt** | Recorrido de cadenas, conteo condicional, funciones auxiliares. |
| 6 | **conversion-temperatura.kt** | Condicionales múltiples (`when`), funciones con parámetros, formateo numérico. |

---

## 🧩 Conceptos clave

- `val` → variable inmutable  
- `var` → variable mutable  
- Inferencia de tipos: Kotlin detecta el tipo sin declararlo explícitamente.  
- Null safety: tipos `?`, operadores `!!`, `?.`, `?:`.  
- Funciones (`fun`): permiten modularizar y reutilizar código.  
- Estructuras de control: `if`, `when`, `for`, `while`.  
- Colecciones: `listOf`, `mutableListOf`, `map`, `filter`.  
- Interpolación de cadenas: `"Hola $nombre"`  

---

## 🧮 Comandos útiles

Compilar un archivo individual:
```bash
kotlinc ruta/al/archivo.kt -include-runtime -d bin/archivo.jar
java -jar bin/archivo.jar
