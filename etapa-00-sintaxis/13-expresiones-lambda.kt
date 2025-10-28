fun main() {
    val sumar = { a: Int, b: Int -> a + b }
    println("Suma con lambda: ${sumar(5, 7)}")

    val numeros = listOf(1, 2, 3, 4, 5)
    val pares = numeros.filter { it % 2 == 0 }
    println("Pares: $pares")
}
