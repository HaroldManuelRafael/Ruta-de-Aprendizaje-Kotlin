fun main() {
    println("Ingrese una lista de números separados por comas (por ejemplo: 10,5,3,20,7): ")
    val entrada = readln()

    // Convertimos la entrada en una lista de enteros
    val numeros = entrada.split(",") // Divide una cadena en partes.
        .map { 
            it.trim() // Quita espacios innecesarios.
            .toIntOrNull() // Convierte texto a número, devuelve null si falla.
        } // Transforma cada elemento de una lista.
        .filterNotNull() // elimina los nulos
    
    print("Ingrese el número mínimo a filtrar: ")
    val limite = readln().toInt()

    // Filtramos los números mayores o iguales al límite
    val filtrados = numeros.filter { it >= limite }

    println("\n Números originales: $numeros")
    println("Números filtrados (>= $limite): $filtrados")

    // Mostramos un resumen con conteo
    println("Se encontraron ${filtrados.size} números que cumplen la condición.")
}