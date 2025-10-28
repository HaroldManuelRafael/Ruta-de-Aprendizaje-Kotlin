fun main() {
    val texto = "42"
    val numero = texto.toInt()
    val decimal = numero.toDouble()
    println("Texto: $texto → Int: $numero → Double: $decimal")

    val invalido = "abc".toIntOrNull()
    println("Conversión inválida devuelve: $invalido")
}
