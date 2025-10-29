class Producto(nombre: String, precio: Double) {
    var nombre: String = nombre
    get() = field.uppercase()
    set(value) {
        field = value.trim()
    }

    var precio: Double = precio
    get() = field
    set(value) {
        field = if(value < 0) 0.0 else value
    }

    fun mostrarInfo() {
        println("Producto: $nombre | Precio: S/ ${"%.2f".format(precio)}")
    }
}

fun main() {
    val p1 = Producto(" manzana ",2.5)
    val p2 = Producto("perra",-3.0)

    p1.mostrarInfo()
    p2.mostrarInfo()

    println("\n--- Modificando valores ---")
    p1.nombre = " durazno "
    p1.precio = 5.8
    p1.mostrarInfo()
}