class Persona {
    var nombre: String = ""
    var edad: Int = 0

    fun saludar() {
        println("Hola, soy $nombre y tengo $edad años.")
    }
}

fun main() {
    val p = Persona()
    p.nombre = "Harold"
    p.edad = 30
    p.saludar()
}