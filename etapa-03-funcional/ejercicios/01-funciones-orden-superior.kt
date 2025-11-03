fun sumar(a: Int, b: Int): Int {
    return a + b
}

fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

fun main() {
    val resultado1 = operar(5, 3, ::sumar)
    println("Resultado usando función normal: $resultado1")

    val resultado2 = operar(5, 3) { x, y -> x * y }
    println("Resultado usando lambda: $resultado2")

    val resta = crearOperacionResta()
    println("Resultado de resta: ${resta(10, 4)}")
}

fun crearOperacionResta(): (Int, Int) -> Int {
    return { a,b -> a - b }
}