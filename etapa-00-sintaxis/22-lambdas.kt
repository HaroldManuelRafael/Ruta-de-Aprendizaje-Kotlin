fun main() {
    println("=== Ejemplos de Lambdas ===")

    // 1️⃣ Lambda básica
    val saludar = { nombre: String -> "Hola, $nombre!" }
    println(saludar("Harold"))

    // 2️⃣ Lambda con más de un parámetro
    val sumar = { a: Int, b: Int -> a + b }
    println("Suma: ${sumar(4, 6)}")

    // 3️⃣ Lambda como parámetro
    fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
        return operacion(a, b)
    }

    println("Multiplicación: ${operar(3, 5) { x, y -> x * y }}")
    println("Resta: ${operar(10, 4) { x, y -> x - y }}")

    // 4️⃣ Uso en listas
    val numeros = listOf(1, 2, 3, 4, 5)
    val pares = numeros.filter { it % 2 == 0 }
    val cuadrados = numeros.map { it * it }

    println("Pares: $pares")
    println("Cuadrados: $cuadrados")
}
