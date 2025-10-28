// 12-funciones-con-retorno.kt
// Demostración de distintos tipos de retorno en funciones Kotlin.

fun main() {
    println("=== 12 · Funciones con Retorno ===")

    // 1) Retorno simple (Int)
    val suma = sumar(7, 5)
    println("sumar(7, 5) = $suma")

    // 2) Cuerpo de expresión (Double)
    println("promedio(10.0, 20.0) = ${promedio(10.0, 20.0)}")

    // 3) Retorno condicional con when (String)
    println("calificar(16.8) = ${calificar(16.8)}")

    // 4) Retorno temprano (guard clause) con validación (Int?)
    println("parsearEntero(\"123\") = ${parsearEntero("123")}")
    println("parsearEntero(\"abc\") = ${parsearEntero("abc")}") // null

    // 5) Valores por defecto + argumentos nombrados (Double)
    println("precioFinal(100.0) = ${precioFinal(100.0)}")
    println("precioFinal(100.0, igv = 10.0, descuento = 5.0) = ${precioFinal(100.0, igv = 10.0, descuento = 5.0)}")

    // 6) Retornar Pair / Triple
    val (min, max) = minMax(listOf(5, 2, 9, 4))
    println("minMax([5,2,9,4]) -> min=$min, max=$max")

    val (c, f, k) = convertirCelsius(25.0)
    println("convertirCelsius(25) -> C=$c, F=$f, K=$k")

    // 7) Retorno de tipo Boolean (predicado)
    println("esPar(8) = ${esPar(8)}, esPar(7) = ${esPar(7)}")

    // 8) Retorno Unit (sin valor): solo efectos secundarios
    logInfo("Fin de la demostración")
}

// 1) Retorno simple con bloque
fun sumar(a: Int, b: Int): Int {
    val r = a + b
    return r
}

// 2) Cuerpo de expresión (forma corta)
fun promedio(x: Double, y: Double): Double = (x + y) / 2

// 3) Retorno con when (sin argumento) → primer caso true retorna
fun calificar(nota: Double): String = when {
    nota >= 17 -> "Excelente"
    nota >= 14 -> "Bueno"
    nota >= 11 -> "Regular"
    else       -> "Deficiente"
}

// 4) Retorno temprano y tipo nullable (Int?)
// - Devuelve null si no se puede convertir a entero
fun parsearEntero(texto: String): Int? {
    val n = texto.toIntOrNull()
    if (n == null) return null
    return n
}

// 5) Parámetros con valores por defecto + argumentos nombrados
// precioFinal = (precio - descuento%) + IGV%
fun precioFinal(precio: Double, igv: Double = 18.0, descuento: Double = 0.0): Double {
    val conDescuento = precio - (precio * descuento / 100)
    return conDescuento + (conDescuento * igv / 100)
}

// 6a) Retornar Pair (dos valores)
fun minMax(numeros: List<Int>): Pair<Int, Int> {
    require(numeros.isNotEmpty()) { "La lista no puede estar vacía" }
    val min = numeros.min()
    val max = numeros.max()
    return Pair(min, max)
}

// 6b) Retornar Triple (tres valores)
fun convertirCelsius(c: Double): Triple<Double, Double, Double> {
    val f = c * 9 / 5 + 32
    val k = c + 273.15
    return Triple(c, f, k)
}

// 7) Predicado (Boolean) con expresión
fun esPar(n: Int): Boolean = n % 2 == 0

// 8) Retorno Unit (implícito) → no devuelve valor, solo efectos secundarios
fun logInfo(mensaje: String) {
    println("ℹ️  $mensaje")
}

/*
Notas clave:
- Toda función declara su tipo de retorno: fun nombre(...): Tipo { ... }
- Si usas cuerpo de expresión (=), el retorno es implícito: fun f(): T = expr
- Tipos nullable (T?) permiten retornar "no hay valor" (null) de forma segura.
- Puedes retornar múltiples valores con Pair/Triple o, mejor aún, con data class.
- Valores por defecto + argumentos nombrados mejoran la legibilidad.
- Unit significa “sin valor de retorno” (equivalente a void), enfocado en efectos secundarios.
*/
