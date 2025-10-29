data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String
)

fun main(){
    val u1 = Usuario(1, "Harold", "harold@mail.com")
    val u2 = Usuario(2, "María", "maria@mail.com")

    println("Usuarios registrados:")
    println(u1)
    println(u2)

    println("\nComparación:")
    println("¿u1 == u2? ${u1 == u2}")

    println("\nCopia de usuarios con cambios:")
    val u3 = u1.copy(email = "nuevo@mail.com")
    println(u3)

    println("\nDesestructuración:")
    val (id,nombre,email) = u3
    println("ID: $id | Nombre: $nombre | Email: $email")
}