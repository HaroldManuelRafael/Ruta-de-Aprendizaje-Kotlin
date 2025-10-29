fun main() {
    println("Ejemplo de formato de columnas en Kotlin\n")

    // Encabezado alineado
    println("%-16s %7s %10s %12s".format("Producto", "Precio", "Cant.", "Subtotal"))
    println("-".repeat(50))

    // Filas de ejemplo
    println("%-16s %7.2f %10d %12.2f".format("Manzana", 2.0, 4, 8.0))
    println("%-16s %7.2f %10d %12.2f".format("Plátano", 3.5, 12, 42.0))
    println("%-16s %7.2f %10d %12.2f".format("Durazno", 5.0, 3, 15.0))

    println("-".repeat(50))
    println("Fin del ejemplo de formato.")
}