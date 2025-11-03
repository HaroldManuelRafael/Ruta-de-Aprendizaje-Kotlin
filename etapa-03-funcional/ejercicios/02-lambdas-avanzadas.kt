fun main() {
    println("=== Ejemplos de Lambdas Avanzadas ===")

    // Lambda con parámetros explícitos
    val sumar = { a: Int, b: Int -> a + b }
    println("Suma: ${sumar(4,6)}")

    // Lambda como  parámetro de función
    fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
        return operacion(a,b)
    }

    val resultado = operar(8,2) { x,y -> x * y }
    println("Resultado multiplicación: $resultado")

    // Lambda con un solo parámetro -> usa 'it'
    val cuadrado = { n: Int -> n * n }
    println("Cuadrado de 5: ${cuadrado(5)}")

    val imprimir = { println("Hola desde lambda!") }
    imprimir()

    // Lambda como valor retornado
    fun obtenerSaludo(): () -> String {
        return { "¡Hola Harold desde una lambda devuelta!" }
    }

    val saludo = obtenerSaludo()
    println(saludo())

    // Ejemplo con colección
    val nombres = listOf("Harold", "María", "Pedro", "Lucía")
    val largos = nombres.filter { it.length > 5 }
    println("Nombres largos: $largos")

}