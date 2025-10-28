fun main() {
    val rango = 1..5
    println("Rango normal: $rango")
    println("¿Contiene 3? ${3 in rango}")

    for (i in 5 downTo 1 step 2) {
        println("Valor: $i")
    }
}
