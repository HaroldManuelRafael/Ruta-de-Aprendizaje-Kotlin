fun main() {
    println("=== Expresiones en kotlin ===")

    //Asignar el resultado de una expresión
    val max = if(10 > 5) 10 else 5
    println("El número mayor es: $max")

    //When también devuelve un valor
    val nota = 17
    val resultado = when {
        nota >= 17 -> "Excelente"
        nota >= 14 -> "Bueno"
        nota >= 11 -> "Regular"
        else -> "Deficiente"
    }
    println("Resultado: $resultado")

    // Try-catch como expresión
    val texto = "123x"
    val numero = try {
        texto.toInt()
    } catch (e: NumberFormatException){
        -1
    }
    println("Resultado del try-catch: $numero")

    //Bloque con valor retornado
    val mensaje = run {
        val nombre = "Harold"
        val saludo = "Hola, $nombre"
        saludo.uppercase()
    }
    println("Resultado del try-catch: $numero")

    //Bloque con valor retornado
    val mensaje = run {
        val nombre = "Harold"
        val saludo = "Hola, $nombre"
        saludo.uppercase()
    }
    println("Mensaje: $mensaje")

    // Expresión dentro de un print
    println("La suma de 3 + 5 es ${3 + 5}")

}