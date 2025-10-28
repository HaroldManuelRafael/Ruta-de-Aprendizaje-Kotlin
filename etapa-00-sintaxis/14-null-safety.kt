fun main() {
    val texto: String? = null

    // Operador seguro
    println("Longitud: ${texto?.length}")

    // Operador Elvis (valor por defecto)
    val longitud = texto?.length ?: 0
    println("Longitud segura: $longitud")

    // Operador !! (riesgoso)
    // println(texto!!.length) // ❌ lanzaría NullPointerException
}
