fun main() {
    println("Ejemplo de null-safety en Kotlin\n")

    var nombre: String? = null

    // ?. → acceso seguro
    println("Longitud segura: ${nombre?.length}") // No lanza error, imprime "null"

    // ?: → valor por defecto
    println("Longitud con valor por defecto: ${nombre?.length ?: 0}")

    // !! → fuerza acceso (lanza error si es null)
    try {
        println("Longitud forzada: ${nombre!!.length}")
    } catch (e: NullPointerException) {
        println("Error: intento de acceder a un valor null con !!")
    }

    // Ahora asignamos un valor real
    nombre = "Harold"
    println("Longitud ahora: ${nombre!!.length}") // Ya no lanza error
}