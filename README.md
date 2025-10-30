# 🧠 Kotlin Learning Roadmap

Este repositorio contiene mi ruta personal de aprendizaje en **Kotlin**, desde los fundamentos del lenguaje hasta el desarrollo de aplicaciones Android y APIs con **Ktor**.

---

## 🚀 Etapas

| Etapa | Tema | Objetivo principal |
|-------|------|--------------------|
| 00 | Sintaxis | Entender la estructura base del lenguaje y el flujo de ejecución |
| 01 | Fundamentos | Dominar variables, funciones, colecciones y operaciones básicas |
| 02 | POO | Aplicar clases, herencia, encapsulación y polimorfismo |
| 03 | Funcional | Comprender lambdas, colecciones y funciones de orden superior |
| 04 | Android | Crear apps móviles simples con Kotlin |
| 05 | Backend (Ktor) | Desarrollar una API REST modular y asincrónica |

---

## 🧩 Requisitos

- [Kotlin Compiler](https://github.com/JetBrains/kotlin/releases)
- [JDK 25 Temurin](https://adoptium.net)
- [VS Code](https://code.visualstudio.com/) con la extensión *Kotlin Language Support*
- (Opcional) Android Studio para la etapa 4

---

## ⚙️ Ejecución de ejemplos

Compila y ejecuta cualquier ejercicio así:

```bash
kotlinc etapa-01-fundamentos/ejercicios/descuento-calculadora.kt -include-runtime -d bin/descuento.jar
java -jar bin/descuento.jar
```

---

## 🧠 Zonas de memoria en un programa

| Zona              | Qué guarda                  | Cuándo se crea              | Cuándo se borra        | Ejemplo                          |
| ----------------- | --------------------------- | --------------------------- | ---------------------- | -------------------------------- |
| **Stack**         | Variables locales, llamadas | Al entrar a una función     | Al salir de la función | `val x = 10` dentro de `fun`     |
| **Heap**          | Objetos, listas             | Al usar `Persona()` o `ArrayList()` | Cuando el GC limpia    | `val persona = Persona()`        |
| **Code Area**     | Código compilado            | Al iniciar el programa      | Al finalizar           | `fun saludar()`                  |
| **Static/Global** | Constantes y compartidos    | Al iniciar el programa      | Al finalizar           | `companion object { var total }` |

💬 **Resumen:**
- El **Stack** es rápido y temporal → guarda las variables que viven dentro de funciones.
- El **Heap** guarda los objetos creados dinámicamente (personas, listas, clases).
- El **Code Area** contiene el código compilado o interpretado que ejecuta la CPU.
- El **Static/Global Area** contiene variables únicas que se comparten entre instancias o durante todo el programa.

---

## ⚙️ Máquina virtual, motor e interpretación

### 🔹 Lenguajes compilados (como **C/C++**)
El código fuente se convierte directamente en **código máquina** que entiende la CPU.
- Más rápido.
- Depende del sistema operativo.
- Ejemplo: `.exe` o binarios nativos.

### 🔹 Lenguajes con **máquina virtual** (como **Kotlin / Java**)
Kotlin compila a **bytecode**, no a código máquina directo.  
Ese bytecode lo ejecuta la **JVM (Java Virtual Machine)**, que actúa como un traductor universal.

📦 **Flujo:**
```
Código Kotlin (.kt)
   ↓ Compilador (kotlinc)
Bytecode (.class)
   ↓ JVM interpreta/ejecuta
Resultado en la CPU
```

💡 Ventajas:
- Multiplataforma (funciona en Windows, Linux, Mac).
- Tiene un **garbage collector** que limpia memoria del Heap automáticamente.
- Permite optimizaciones en tiempo de ejecución.

---

### 🔹 Lenguajes con **motores** (como **JavaScript**)
Un **motor** (por ejemplo, V8 en Chrome o Node.js) lee el código **en texto plano** y lo ejecuta *al vuelo*.

📦 **Flujo:**
```
Código JavaScript (.js)
   ↓ Motor V8 (interpreta + optimiza)
Resultado inmediato
```

💬 El motor no crea una máquina virtual separada, sino que interpreta directamente el código dentro del entorno (navegador o Node).

---

### ⚙️ Comparativo rápido

| Lenguaje | Tipo de ejecución | Quién lo ejecuta | Qué genera |
|-----------|-------------------|------------------|-------------|
| **C++** | Compilado | CPU directamente | Binario nativo |
| **Kotlin / Java** | Compilado a bytecode | JVM | `.class` / `.jar` |
| **JavaScript** | Interpretado (motor V8) | Navegador / Node | No genera binario persistente |

---

💬 En pocas palabras:
> 🧠 **Kotlin** usa una *máquina virtual* (JVM) → seguridad, portabilidad y recolección de basura.  
> ⚙️ **JavaScript** usa un *motor* (V8) → ejecución rápida, sin compilación previa.  
> 🧩 **C/C++** va directo a la CPU → máximo rendimiento, menos seguridad.