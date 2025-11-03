// COMPILAR: kotlinc -classpath lib/kotlinx-coroutines-core-jvm-1.8.1.jar 09-coroutines-avanzado.kt -include-runtime -d bin/coroutinesAvanzado.jar
// EJECUTAR: java -classpath "bin/coroutinesAvanzado.jar;lib/kotlinx-coroutines-core-jvm-1.8.1.jar" _09_coroutines_avanzadoKt
import kotlinx.coroutines.*

suspend fun tareaLenta(nombre: String, tiempo: Long): Int {
    println("Inciando $nombre...")
    delay(tiempo)
    println("$nombre completada después de ${tiempo}ms")
    return (1..100).random()    
}

fun main() = runBlocking {
    println("Inicio del programa (hilo principal)")

    val tiempoInicio = System.currentTimeMillis()

    val resultado1 = async { tareaLenta("Tarea A", 1500)}
    val resultado2 = async { tareaLenta("Tarea B", 1000)}

    println("Esperando resultados...")
    val total = resultado1.await() + resultado2.await()

    val tiempoFin = System.currentTimeMillis()
    println("Resultado total: $total" )
    println("Tiempo total: ${tiempoFin - tiempoInicio} ms")

    println("Fin del programa (hilo principal)")
}