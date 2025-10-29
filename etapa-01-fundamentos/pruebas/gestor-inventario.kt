fun main(){
    print("¿Cuantos productos desea ingresar? ")
    val numeroDeProductos: Int? = readln().toIntOrNull()

    if(!validarNumeroDeProductos(numeroDeProductos)) return

    println("Se registraran $numeroDeProductos productos")
    
    val productos = ingresarProductos(numeroDeProductos)

    println("=== Inventario ===")
    val encabezado = "%-16s %7s %10s %12s".format("Producto","Precio","Cantidad","Subtotal")
    val barra = "-".repeat(encabezado.length)
    println(encabezado)
    println(barra)
    val (total, sumaPrecios, mayorNombre) = listarProductos(productos)
    val promedio = calcularPromedio(sumaPrecios,numeroDeProductos)
    println(barra)

    println("%-5s %4s %4.2f".format("Total general",":",total))
    println("%-5s %1s %4.2f".format("Promedio precios",":",promedio))
    println("%-5s %9s %4s".format("Más caro",":",mayorNombre["mayor"]))
    println("%-5s %7s %4s".format("Más barato",":",mayorNombre["menor"]))
}

fun validarNumeroDeProductos(cantidad: Int?): Boolean {
    if(cantidad == null || cantidad <= 0) {
        print("Ingrese número valido.")
        return false
    }
    return true
}

fun ingresarProductos(cantidad: Int?): MutableList<MutableMap<String, Any>>{
    val productos = mutableListOf<MutableMap<String,Any>>()
    for(i in 1..(cantidad ?: 0)){
        val item = mutableMapOf<String, Any>()
        println("Ingrese producto numero $i")
        
        print(" Ingrese nombre: ")
        val nombre = readln().trim()

        print(" Ingrese precio: ")
        var precio = readln().toDoubleOrNull() ?: 0.0

        print(" Ingrese cantidad: ")
        var cantidad = readln().toIntOrNull() ?: 0

        item["nombre"] = nombre
        item["precio"] = precio
        item["cantidad"] = cantidad

        productos.add(item)
    }
    return productos
}

fun listarProductos(
    productos: MutableList<MutableMap<String, Any>>
): Triple<Double, Double, Map<String,String>> {
    var total = 0.0
    var sumaPrecios = 0.0

    var mayorPrecio: Double? = null
    var menorPrecio: Double? = null
    var mayorNombre = ""
    var menorNombre = ""

    for (producto in productos) {
        val nombre = producto["nombre"] as String
        val precio = producto["precio"] as Double
        val cantidad = producto["cantidad"] as Int
        val subtotal = calcularSubtotal(precio, cantidad)

        sumaPrecios += precio
        total += subtotal

        if(mayorPrecio == null || menorPrecio == null) {
            mayorPrecio = precio
            menorPrecio = precio
            mayorNombre = nombre
            menorNombre = nombre
        } else {
            if(precio > mayorPrecio!!) {
                mayorPrecio = precio
                mayorNombre = nombre
            }

            if(precio < menorPrecio!!) {
                menorPrecio = precio
                menorNombre = nombre
            }        
        }
        println("%-16s %7.2f %10d %12.2f".format(nombre, precio, cantidad, subtotal))
    }

    val extremos = mapOf("mayor" to mayorNombre, "menor" to menorNombre)
    return Triple(total, sumaPrecios, extremos)
}

fun calcularSubtotal(precio: Double, cantidad: Int): Double {
    val subtotal = precio * cantidad
    return subtotal
}

fun calcularPromedio(sumaPrecios: Double, numero: Int?): Double {
    if(numero == null || numero == 0) {
        return 0.0
    } 
    return sumaPrecios / numero 
}