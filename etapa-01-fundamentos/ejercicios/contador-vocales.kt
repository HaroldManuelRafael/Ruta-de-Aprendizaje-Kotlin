fun main() {
    println("Contador de Vocales")

    print("Ingrese una palabra o frase: ")
    val texto = readln()

    val totalVocales = contarVocales(texto)

    println("\n Texto ingresado: \"$texto\"")
    println("Cantidad de vocales: $totalVocales")
}

fun contarVocales(texto: String): Int{
    val vocales = listOf('a','e','i','o','u','A','E','I','O','U')

    var contador = 0
    for (c in texto) {
        if(c in vocales) contador++
    }
    return contador
}