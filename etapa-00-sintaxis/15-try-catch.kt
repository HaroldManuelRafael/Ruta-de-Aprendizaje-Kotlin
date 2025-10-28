fun main() {
    try {
        print("Ingrese un número: ")
        val n = readln().toInt()
        println("Número ingresado: $n")
    } catch (e: NumberFormatException) {
        println("⚠️ Error: debe ingresar un número válido.")
    } finally {
        println("Programa finalizado.")
    }
}
