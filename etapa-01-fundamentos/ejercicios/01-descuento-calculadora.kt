fun main() { // Este bloque es el punto de entrada
    print("Ingrese el precio original: ") // Muestra el texto sin salto de línea, no almacena en memoria.
    val precio = readln().toDouble() // Se espera que se ingrese un valor, se convierte a decimal y se guarda el valor en una variable inmutable.
    val impuesto = 18.0 // Guarda el valor en una variable inmutable.

    print("Ingrese el porcentaje de descuento: ") //Muestra el texto sin salto de línea.
    val descuento = readln().toDouble() // Se espera que se ingrese un valor, se convierte a decimal y se guarda el valor en una variable inmutable.

    val precioConDescuento = precio - (precio * descuento / 100) // Operación aritmética común.
    val precioFinal = precioConDescuento + (precioConDescuento * impuesto / 100) // Operación aritmética común.

    println("Precio final con descuento: $precioConDescuento") // El símbolo $ dentro de una cadena te permite interpolar variables.
    println("Precio final descontado con impuesto: $precioFinal") // El símbolo $ dentro de una cadena te permite interpolar variables.
}