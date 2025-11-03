data class Persona(var nombre: String, var edad: Int, var ciudad: String? = null)

fun main(){
    println("=== Let ===")
    val nombre = "Harold"
    val resultadoLet = nombre.let { 
        println("El nombre tiene ${it.length} letras.")
        it.uppercase()
    }
    println("Resultado del let: $resultadoLet")

    println("\n=== run ===")
    val mensaje = run {
        val saludo = "Hola"
        val nombre = "Lucía"
        "$saludo, $nombre!".uppercase()
    }
    println("Resultado del run: $mensaje")

    println("\n=== apply ===")
    val persona = Persona("Pedro", 27).apply { 
        ciudad = "Huancayo"
        edad += 1
     }
     println("Persona configurada con apply: $persona")     

     println("\n=== also ===")
     val numeros = mutableListOf(1, 2, 3).also { 
        println("Lista inicial: $it")
        it.add(4)
     }
     println("Lista final después del also: $numeros")

     println("\n=== with ===")
     val resultadoWith = with(persona) { 
        println("Nonbre: $nombre")
        println("Edad: $edad")
        "Ciudad: ${ciudad ?: "No especificada"}"
      }
      println("Resultado de with: $resultadoWith")

}