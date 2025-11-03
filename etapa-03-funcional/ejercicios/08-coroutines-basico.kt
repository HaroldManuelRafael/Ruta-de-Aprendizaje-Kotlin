//COMPILAR: kotlinc -classpath lib/kotlinx-coroutines-core-jvm-1.8.1.jar 08-coroutines-basico.kt -include-runtime -d bin/coroutines.jar
// EJECUTAR: java -classpath "bin/coroutines.jar;lib/kotlinx-coroutines-core-jvm-1.8.1.jar" _08_coroutines_basicoKt
import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Inicio del programa (hilo principal)")

    launch {
        for (i in 1..5) {
            println("Coroutine 1 -> paso $i")
            delay(500)
        }
    }

    launch {
        for (i in 1..5) {
            println("Coroutine 2 -> paso $i")
            delay(700)
        }
    }

    println("Coroutines lanzadas...")
    delay(4000)
    println("Fin del programa (hilo principal)")
}