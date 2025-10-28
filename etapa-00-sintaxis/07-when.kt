fun main() {
    print("Ingrese una calificación (A, B, C, D): ")
    val nota = readln().uppercase()

    val mensaje = when (nota) {
        "A" -> "Excelente"
        "B" -> "Bueno"
        "C" -> "Regular"
        "D" -> "Deficiente"
        else -> "No reconocida"
    }
    println("Resultado: $mensaje")
}
