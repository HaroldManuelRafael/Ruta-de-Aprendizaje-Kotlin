// 🔹 Clases "normales" en Kotlin son FINALES por defecto
// Es decir: no se pueden heredar a menos que las marques con 'open'

open class Animal(val nombre: String) {
    // Las funciones también deben ser 'open' para poder sobrescribirse
    open fun hacerSonido() {
        println("$nombre hace un sonido genérico")
    }

    // Esta función NO podrá ser sobrescrita
    fun dormir() {
        println("$nombre está durmiendo 💤")
    }
}

// 🔹 'override' sirve para reemplazar una función del padre
class Perro(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: ¡Guau guau! 🐶")
    }
}

class Gato(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: ¡Miau! 🐱")
    }
}

fun main() {
    val a = Animal("Criatura")
    val p = Perro("Firulais")
    val g = Gato("Michi")

    a.hacerSonido()
    p.hacerSonido()
    g.hacerSonido()

    // Heredan 'dormir()' pero no pueden modificarla
    p.dormir()
    g.dormir()
}
