fun main() {
    println("Conversor de Temperaturas")

    print("Ingrese la temperatura: ")
    val valor = readln().toDoubleOrNull()

    if(valor == null) {
        println("Entrada inválida. Debe ingresar un número.")
        return
    }

    println("Seleccione la unidad de origen: ")
    println("1 Celsius(°C)")
    println("2 Fahrenheit (°F)")
    println("3 Kelvin (K)")
    print("Opción: ")
    val opcion = readln().toIntOrNull()

    when(opcion){ // Actúa como un switch
        1 -> mostrarConversionesDesdeCelsius(valor)
        2 -> mostrarConversionesDesdeFahrenheit(valor)
        3 -> mostrarConversionesDesdeKelvin(valor)
        else -> println("Opción inválida.")
    }
}

fun mostrarConversionesDesdeCelsius(c: Double) {
    val f = c * 9/5 + 32
    val k = c + 273.15
    println("\n$c°C equivalen a:")
    println("%.2f°F".format(f))
    println("%.2fk".format(k))
}

fun mostrarConversionesDesdeFahrenheit(f: Double) {
    val c = (f - 32) * 5/9
    val k = c + 273.15
    println("\n$f°F equivalen a:")
    println("%.2f°C".format(c)) // Control de decimales %.2f -> maximo 2 decimales
    println("%.2fK".format(k))
}

fun mostrarConversionesDesdeKelvin(k: Double) {
    val c = k - 273.15
    val f = c * 9/5 + 32
    println("\n$k K equivalen a:")
    println("%.2f°C".format(c))
    println("%.2f°F".format(f))
}