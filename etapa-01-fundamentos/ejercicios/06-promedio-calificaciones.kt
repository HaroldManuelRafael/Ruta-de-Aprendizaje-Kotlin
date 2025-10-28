fun main() {
    println("Cálculo de Promedio de Calificaciones")

    print("¿Cuántas notas desea ingresar? ")
    val cantidad = readln().toInt() // Despues de almacenar el valor lo convertimos a entero.

    val notas = mutableListOf<Double>() // Crea una lista mutable con numeros decimales.

    // Captura de notas con validación
    for (i in 1..cantidad) { // Repite el bucle desde 1 hasta la cantidad ingresada.
        print("Ingrese la nota #$i: ")
        val nota = readln().toDoubleOrNull() // Despues de almacenar el valor lo convertimos a decimal sino se puede devuelve null.

        if(nota != null && nota in 0.0..20.0) { // rango de 0.0 hasta 20.0
            notas.add(nota)
        } else {
            println("Nota inválida. Debe estar entre 0 y 20.")
        }
    }

    if(notas.isNotEmpty()) {
        val promedio = notas.average()

        println("\n Notas ingresadas: $notas")
        println("Promedio: %.2f".format(promedio))
        println("Resultado: ${evaluarDesempeno(promedio)}")
    } else {
        println("No se ingresaron notas válidas.")
    }
}

fun evaluarDesempeno(promedio: Double): String {
    return when {
        promedio >= 17 -> "Excelente"
        promedio >= 14 -> "Bueno"
        promedio >= 11 -> "Regular"
        else -> "Deficiente"
    }
}