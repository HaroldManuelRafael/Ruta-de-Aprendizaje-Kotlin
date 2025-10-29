data class Producto(
    val nombre: String,
    val precio: Double,
    val categoria: String
)

fun main() {
    val productos = listOf(
        Producto("Manzana", 2.5, "Fruta"),
        Producto("Pera", 3.0, "Fruta"),
        Producto("Leche", 4.5m "Lácteo"),
        Producto("Queso", 8.0, "Lácteo"),
        Producto("Pan", 1.2m "Panadería")
    )

    println("=== Lista completa de productos ===")
    productos.forEach { println(it) }

    println("\n=== Productos de categoría 'Fruta' ===")
    val frutas = productos.filter { it.categoria == "Fruta" }
    frutas.forEach { println(it.Nombre) }

    println("\n=== Producto más caro ===")
    val masCaro = productos.maxByOrNull { it.precio }
    println(masCaro)

    println("\n=== Promedio de precios ===")
    val promedio = productos.map { it.precio }.average()
    println("S/ %.2f".format(promedio))
}