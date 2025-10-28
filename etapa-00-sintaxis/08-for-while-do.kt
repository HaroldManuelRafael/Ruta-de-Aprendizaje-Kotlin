fun main() {
    // Bucle for
    for (i in 1..5) println("Iteración #$i")

    // Bucle while
    var contador = 3
    while (contador > 0) {
        println("Cuenta atrás: $contador")
        contador--
    }

    // Bucle do-while (se ejecuta al menos una vez)
    var x = 0
    do {
        println("do-while ejecutado con x=$x")
        x++
    } while (x < 2)
}
