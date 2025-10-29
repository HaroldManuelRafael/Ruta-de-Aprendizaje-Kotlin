open class Producto(
    val nombre: String,
    var precio: Double
) {
    open fun mostrarInfo(){
        println("Producto: $nombre | Precio: S/ ${"%.2f".format(precio)}")
    }
}

class Alimento(
    nombre: String,
    precio: Double,
    val fechaVencimiento: String
): Producto(nombre, precio) {
    override fun mostrarInfo() {
        println("Alimento: $nombre | Precio: S/ ${"%.2f".format(precio)} | Vence: $fechaVencimiento")
    }
}

class Bebida(
    nombre: String,
    precio: Double,
    val volumenLitros: Double
): Producto(nombre, precio) {
    override fun mostrarInfo() {
        println("Bebida: $nombre | Precio: S/ ${"%.2f".format(precio)} | Volumen: ${volumenLitros}L")
    }
}

fun main() {
    val p = Producto("Lapicero",1.5)
    val a = Alimento("Galletas", 2.5, "15/12/2025")
    val b = Bebida("Agua Mineral", 1.8, 0.6)

    val lista = listOf(p,a,b)

    println("=== Inventario ===")
    for(item in lista){
        item.mostrarInfo()
    }
}