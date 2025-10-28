fun main() {
    saludar("Harold")
    val suma = sumar(5, 7)
    println("Resultado de la suma: $suma")
}

fun saludar(nombre: String) {
    println("Hola, $nombre!")
}

fun sumar(a: Int, b: Int): Int {
    return a + b
}
