fun main() {
    val edades = mapOf("Ana" to 20, "Luis" to 25, "Karla" to 22)
    println("Edades: $edades")

    val precios = mutableMapOf("Manzana" to 2.5)
    precios["Pera"] = 3.0
    println("Precios actualizados: $precios")

    for ((fruta, precio) in precios) {
        println("La $fruta cuesta S/. $precio")
    }
}
