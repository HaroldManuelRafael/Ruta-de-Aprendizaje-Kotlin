

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)

fun pausar() {
    println("\nPresione ENTER para volver al menú...")
    readln()
}

fun tabla(inventario: List<Producto>) {
    val barra = "=".repeat(50)
    println(barra)
    println("%s %-20s%-10s%-5s".format("ID", "Nombre", "Precio", "Cant."))
    println(barra)
    inventario.forEach {
        println("%d %-20s %-10.2f %-5d".format(
            it.id,            
            it.nombre, 
            it.precio, 
            it.cantidad            
        ))
    }
    println(barra)
}

fun mostrarInventario(lista: List<Producto>){
    println("Mostrar inventario")
    tabla(lista)
    pausar()
}

fun agregarProducto(lista: List<Producto>): List<Producto>{
    println("Agregar producto")
    print("Ingresar titulo: ")
    val titulo = readln().toString()

    print("Ingresar precio: ")
    val precio = readln().toDoubleOrNull() ?: println("precio inválido.")

    print("Ingresar cantidad: ")
    val cantidad = readln().toIntOrNull() ?: println("Cantidad inválida.")

    val aumento = 1
    val indiceMaximo = lista.maxOfOrNull { it.id } ?: 0
    val indiceNuevo =  indiceMaximo + aumento
    val productoNuevo =  Producto(indiceNuevo, titulo, precio as Double, cantidad as Int)
    val nuevaLista = lista + productoNuevo

    return nuevaLista    
}

fun actualizarStock(lista: List<Producto>): List<Producto> {
    println("Actualizar stock")

    tabla(lista)

    print("Ingrese id: ")
    val id = readln().toIntOrNull() ?: println("ID inválido.")

    print("Nueva cantidad: ")
    val nuevaCantidad = readln().toIntOrNull() ?: println("Cantidad inválida.")

    val nuevaLista = lista.map {
        producto -> 
        if (producto.id == id)
            producto.copy(cantidad = nuevaCantidad as Int)
        else
            producto
    }

    println("Stock actualizado correctamente.")
    return nuevaLista
}

fun filtrarPorPrecio(lista: List<Producto>){
    println("Filtrar por precio")
    print("Ingrese minimo: ")
    val minimo = readln().toDoubleOrNull() ?: println("Minimo inválido.")
    val nuevaLista = lista.filter { it.precio >= minimo as Double }
    tabla(nuevaLista)
    pausar()
}

fun calcularTotal(lista: List<Producto>){
    val total = lista.sumOf { it.precio * it.cantidad }
    println("Suma total: %.2f".format(total))
    pausar()    
}

fun eliminarProducto(lista: List<Producto>): List<Producto> {
    println("Eliminar producto")

    tabla(lista)

    print("Ingresar id: ")
    val id = readln().toIntOrNull() ?: println("ID inválido.")

    val nuevaLista = lista.filter { producto ->
        producto.id != id
    }

    return nuevaLista
}

fun formatoMenu(titulo: String) {
    val accion = "%-5s".format(titulo)
    println(accion)
}

fun main() {

    var inventario = listOf (
        Producto(1,"Cuaderno", 12.0, 15),
        Producto(2,"Libro", 20.0, 12)
    )
    
    val menus = listOf(
        "1. Listar productos",
        "2. Agregar productos",
        "3. Actualizar stock",
        "4. Filtrar por precio",
        "5. Calcular total",
        "6. Eliminar producto",
        "7. Salir",
    )

    do {
        println("${"=".repeat(3)} Inventario Funcional ${"=".repeat(3)}")
        menus.forEach { formatoMenu(it) }
        print("Ingrese opción: ")
        val opc = readln().toInt()
        when(opc){
            1 -> mostrarInventario(inventario)
            2 -> inventario = agregarProducto(inventario)
            3 -> inventario = actualizarStock(inventario)
            4 -> filtrarPorPrecio(inventario)
            5 -> calcularTotal(inventario)
            6 -> inventario = eliminarProducto(inventario)
            else -> return
        }
    } while(opc != 7)

}

