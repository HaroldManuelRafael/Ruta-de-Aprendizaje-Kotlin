fun main() {
    println("=== Ejemplo 1: Listas inmutables ===")
    val numeros = listOf(1, 2, 3, 4)
    println("Lista original: $numeros")

    // Intentar modificar (error)
    // numeros.add(5) x No se puede
    // numeros[0] = 10 X No se puede

    // En lugar de eso, creamos una nueva lista
    val nuevaLista = numeros + 5
    println("Lista nueva (sin modificar la original): $nuevaLista")
    println("Lista original sigue igual: $numeros")

    println("\n=== Ejemplo 2: Listas mutables ===")
    val mutable = mutableListOf(1,2,3,4)
    mutable.add(5)
    mutable[0] = 10
    println("Lista mutable modificada: $mutable")

    println("\n=== Ejemplo 3: Mapas inmutables ===")
    val precios = mapOf("Manzana" to 2.5, "Pera" to 3.0)
    println("Mapa original: $precios")

    val nuevoPrecio = precios + ("Uva" to 4.0)
    println("Nuevo mapa (creado, no modificado): $nuevoPrecio")
    println("Mapa original sigue igual: $precios")

    println("\n=== Ejemplo 4: Mapas mutables ===")
    val preciosMutables = mutableMapOf("Manzana" to 2.5, "Pera" to 3.0)
    preciosMutables["Uva"] = 4.0
    preciosMutables["Manzana"] = 2.8
    println("Mapa mutable actualizado: $preciosMutables")

    println("\n=== Ejemplo 5: Copiar objetos inmutables ===")
    data class Producto(val nombre: String, val precio: Double)

    val p1 = Producto("Laptop", 3500.0)
    val p2 = p1.copy(precio = 3000.0)

    println("Producto original: $p1")
    println("Producto modificado (nuevo objeto): $p2")

    println("\n=== Ejemplo 6: Ventaja práctica ===")
    val original = listOf(1, 2, 3)
    val duplicados = original.map { it * 2 }

    println("Original: $original")
    println("Duplicados: $duplicados")

    println("\n Conclusión:")
    println("Usar estructuras inmutables evita errores y hace el código más predecible.")
}