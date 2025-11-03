//COMPILAR: kotlinc -classpath lib/kotlinx-coroutines-core-jvm-1.8.1.jar 10-mini-proyecto-coroutines.kt -include-runtime -d bin/proyecto-coroutines.jar
//EJECUTAR: java -classpath "bin/proyecto-coroutines.jar;lib/kotlinx-coroutines-core-jvm-1.8.1.jar" _10_mini_proyecto_coroutinesKt

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun descargarArchivo(nombre: String, tiempo: Long): String {
    println("Iniciando descargar de $nombre")
    delay(tiempo)
    println("Descargar completada: $nombre")
    return "$nombre (${tiempo}ms)"
}

fun main() = runBlocking {
    println("=== Simulador de Descargas Concurrentes ===")

    val tiempoTotal = measureTimeMillis { 
        val archivos = listOf(
            async { descargarArchivo("video.mp4", 2000L)},
            async { descargarArchivo("imagen.png", 1500L)},
            async { descargarArchivo("documento.pdf", 1000L)},
            async { descargarArchivo("musica.mp3", 1800L) }
        )     

        println("Esperando todas las descargas...")
        val resultados = archivos.awaitAll()

        println("\n Archivos descargados:")
        resultados.forEach { println("   - $it") }     
    }

    println("\nTiempo total: ${tiempoTotal}ms")
    println("Todas las descargas finalizaron correctamente.")
}

