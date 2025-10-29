class Persona {
    var nombre: String = ""
    var edad: Int = 0
}

fun main() {
    val persona1 = Persona()
    persona1.nombre = "Harold"
    persona1.edad = 30

    println("Nombre: ${persona1.nombre}")
    println("Edad: ${persona1.edad}")
}