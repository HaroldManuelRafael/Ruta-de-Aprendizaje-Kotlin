/*
 Las data class son clases diseñadas para almacenar datos.
 Kotlin genera automáticamente varios métodos útiles:

 1. equals() → compara si dos objetos tienen el mismo contenido.
 2. hashCode() → usado en estructuras como Set o Map.
 3. toString() → devuelve una representación legible del objeto.
 4. copy() → clona el objeto con posibilidad de cambiar campos.
 5. componentN() → permite desestructurar el objeto.
*/

// ✅ Versión con data class (automática)
data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String
)

fun main() {
    val u1 = Usuario(1, "Harold", "harold@mail.com")
    val u2 = Usuario(2, "María", "maria@mail.com")

    println("Usuarios registrados:")
    println(u1)   // usa toString()
    println(u2)

    println("\nComparación por contenido:")
    println("¿u1 == u2? ${u1 == u2}")   // usa equals()

    println("\nCopia de usuario con cambios:")
    val u3 = u1.copy(email = "nuevo@mail.com")  // usa copy()
    println(u3)

    println("\nDesestructuración del objeto:")
    val (id, nombre, email) = u3                // usa componentN()
    println("ID: $id | Nombre: $nombre | Email: $email")

    println("\nUso en un Set (usa hashCode):")
    val usuarios = setOf(u1, u2, u3)
    println("Cantidad en Set: ${usuarios.size}") // no duplica objetos con mismos datos

    // ───────────────────────────────────────────────
    // Comparación con una clase normal
    // ───────────────────────────────────────────────

    println("\n--- Comparación con clase normal ---")
    val c1 = Cliente(1, "Harold", "harold@mail.com")
    val c2 = Cliente(1, "Harold", "harold@mail.com")

    println("Clientes:")
    println(c1)  // sin toString() personalizado
    println(c2)

    println("¿c1 == c2? ${c1 == c2}") // Compara referencias (no contenido)
}

// ❌ Versión sin data class (todo manual)
class Cliente(
    val id: Int,
    val nombre: String,
    val email: String
) {
    // Sobrescribimos equals() manualmente
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cliente) return false
        return id == other.id && nombre == other.nombre && email == other.email
    }

    // Sobrescribimos hashCode() manualmente
    override fun hashCode(): Int {
        var result = id
        result = 31 * result + nombre.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    // Sobrescribimos toString() manualmente
    override fun toString(): String {
        return "Cliente(id=$id, nombre=$nombre, email=$email)"
    }
}
