fun main(){
    print("Ingrese su correo electrónico: ")
    val email = readln()

    if(esEmailValido(email)) {
        println("El correo '$email' es válido.")
    } else {
        println("El correo '$email' no es válido.")
    }
}

fun esEmailValido(email: String): Boolean {
    val patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    return patron.matches(email)
}