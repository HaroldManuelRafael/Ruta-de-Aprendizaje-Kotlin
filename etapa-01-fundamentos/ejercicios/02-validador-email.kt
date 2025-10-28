fun main(){
    print("Ingrese su correo electrónico: ") // Muestra el texto en una sola línea.
    val email = readln() // Guarda el valor en una variable inmutable.

    if(esEmailValido(email)) { // LLama a la función y espera un retorno.
        println("El correo '$email' es válido.")
    } else {
        println("El correo '$email' no es válido.")
    }
}

fun esEmailValido(email: String): Boolean {
    val patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex() // Expresión regular para validar el formato correo@gmail.com
    // ^ Inicio del patron
    // $ Final del patron
    // [] Conjunto, permite varios caracteres posibles.
    // + Cuantificador, una o mas repeticiones
    // \\ Escape, para escribir símbolos especiales
    return patron.matches(email) // Retorna un verdadero o falso segun el patron.
}