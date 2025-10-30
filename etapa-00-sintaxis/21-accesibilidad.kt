// Por defecto, todo en Kotlin es 'public' (visible desde cualquier parte)

open class Persona(
    val nombre: String,
    private val dni: String // 🔒 Solo accesible dentro de la clase
) {
    protected var edad: Int = 0 // 👀 Visible en clases hijas, no fuera de la jerarquía

    fun mostrarPublico() {
        println("👤 Nombre: $nombre")
    }

    private fun mostrarPrivado() {
        println("🔒 DNI: $dni")
    }

    protected fun mostrarProtegido() {
        println("🧩 Edad: $edad")
    }

    fun verTodoDesdeDentro() {
        mostrarPublico()
        mostrarPrivado()
        mostrarProtegido()
    }
}

// Clase hija que accede a lo protegido
class Empleado(nombre: String, dni: String, val cargo: String) : Persona(nombre, dni) {
    fun mostrarEmpleado() {
        println("Empleado: $nombre - Cargo: $cargo")
        edad = 30 // ✅ se puede modificar porque es 'protected'
        mostrarProtegido() // ✅ accesible en la hija
    }
}

// Clase final (no se puede heredar)
final class Cliente(val codigo: Int, nombre: String, dni: String) : Persona(nombre, dni) {
    fun mostrarCliente() {
        println("🛒 Cliente $codigo: $nombre")
    }
}

fun main() {
    val e = Empleado("Harold", "12345678", "Desarrollador")
    e.mostrarPublico()
    e.mostrarEmpleado()
    e.verTodoDesdeDentro() // ✅ todo lo público y lo interno

    val c = Cliente(101, "María", "87654321")
    c.mostrarCliente()
    c.mostrarPublico()
    c.

    // ❌ c.edad no se puede acceder (protected)
    // ❌ c.dni no se puede acceder (private)
}
