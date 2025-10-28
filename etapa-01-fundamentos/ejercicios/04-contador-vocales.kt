fun main() {
    println("Contador de Vocales")

    print("Ingrese una palabra o frase: ")
    val texto = readln()

    val totalVocales = contarVocales(texto) // Kotlin pausa la ejecución de main() y ejecuta el contenido de la función.

    println("\n Texto ingresado: \"$texto\"")
    println("Cantidad de vocales: $totalVocales")
}

fun contarVocales(texto: String): Int{
    val vocales = listOf('a','e','i','o','u','A','E','I','O','U') // Lista inmutable de caracteres.

    var contador = 0 // Aquí creamos un contador mutable.
    for (c in texto) { // Este bucle recorre cada carácter del texto.
        if(c in vocales) contador++ // Usamos el operador in para comprobar si el caracter existe en la lista. Aumenta el contador en 1.
    }
    return contador // Devuelve el número total de vocales encontradas.
}