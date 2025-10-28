# 🧠 Kotlin Learning Roadmap

Este repositorio contiene mi ruta personal de aprendizaje en **Kotlin**, desde los fundamentos del lenguaje hasta el desarrollo de aplicaciones Android y APIs con **Ktor**.

## 🚀 Etapas

| Etapa | Tema | Objetivo principal |
|-------|------|--------------------|
| 01 | Fundamentos | Dominar la sintaxis base de Kotlin |
| 02 | POO | Aplicar clases, herencia y encapsulación |
| 03 | Funcional | Comprender lambdas, colecciones y funciones de orden superior |
| 04 | Android | Crear apps móviles simples con Kotlin |
| 05 | Backend (Ktor) | Desarrollar una API REST modular |

## 🧩 Requisitos
- [Kotlin Compiler](https://github.com/JetBrains/kotlin/releases)
- [JDK 25 Temurin](https://adoptium.net)
- [VS Code](https://code.visualstudio.com/) con la extensión *Kotlin Language Support*
- (Opcional) Android Studio para la etapa 4

## 🧠 Cómo ejecutar ejemplos
```bash
kotlinc etapa-01-fundamentos/ejercicios/descuento-calculadora.kt -include-runtime -d bin/descuento.jar
java -jar bin/descuento.jar
