fun main() {
    val frutas = listOf("Manzana", "Pera", "Plátano")
    val precios = mutableListOf(2.5, 3.0, 1.8)

    println("Frutas: $frutas")
    precios.add(2.2)
    println("Precios actualizados: $precios")

    for (f in frutas) println("🍎 $f")
}
