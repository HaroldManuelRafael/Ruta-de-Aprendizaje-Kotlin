class Persona(val nombre: String, val edad: Int){
    fun saludar() = println("Hola, soy $nombre y tengo $edad años.")
}

fun main(){
    val p = Persona("Harold",30)
    p.saludar()
}