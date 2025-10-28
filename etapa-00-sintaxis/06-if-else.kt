fun main() {
    print("Ingrese su edad: ")
    val edad = readln().toInt()

    if (edad >= 18) {
        println("Eres mayor de edad")
    } else {
        println("Eres menor de edad")
    }
}
