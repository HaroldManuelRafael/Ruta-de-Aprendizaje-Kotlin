fun main(){
    print("Ingrese el precio original: ")
    val precio = readln().toDouble()
    val impuesto = 18.0

    print("Ingrese el porcentaje de descuento: ")
    val descuento = readln().toDouble()

    val precioConDescuento = precio - (precio * descuento / 100)
    val precioFinal = precioConDescuento + (precioConDescuento * impuesto / 100)

    println("Precio final con descuento: $precioConDescuento")
    println("Precio final descontado con impuesto: $precioFinal")
}