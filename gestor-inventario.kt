fun main(){
    print("¿Cuantos productos desea ingresar? ")
    val cantidad = readln().toIntOrNull()

    if(cantidad == null || cantidad <= 0) {
        print("Ingrese cantidad valida.")
        return
    }

    println("Se registraran $cantidad productos")
    
    val productos = mutableListOf<String>()
    for(i in 1..cantidad){
        val producto = mutableMapOf<String, Any>()
        println("Ingrese producto numero $i")
        println("Ingrese nombre: ")
        val nombre = readln()
        println("El producto es: $nombre")
    }

}