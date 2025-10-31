

data class Nota (val id: Int, val titulo: String, val contenido: String, val fecha: String)

class RepositorioNotas() {

    private val libreta = mutableListOf<Nota>()
    private var encabezado = "%-2s %-10s %-30s %-30s".format("Id","Titulo","Contenido","Fecha")

    fun agregarNota(){
        val aumento = 1
        val cantidadDeNotas = libreta.maxOfOrNull { it.id } ?: 0
        val indice = cantidadDeNotas + aumento

        print("Ingrese título: ")
        val titulo = readln().toString()
        print("Ingrese contenido: ")
        val contenido = readln().toString()
        print("Ingrese fecha: ")
        val fecha = readln().toString()

        if(titulo.isBlank() || contenido.isBlank()) {
            println("El título y contenido no pueden estar vacíos.")
            return
        }

        val nota = Nota(indice,titulo,contenido,fecha)
        libreta.add(nota)
        println("Se registro la nota $titulo.[Total: ${libreta.size}]")
    }

    fun listarNotas(){
        println("Se esta listando las notas")
        tabla()
    }

    fun buscarPorTitulo(){
        print("Ingrese titulo a buscar: ")
        val busqueda = readln().toString()

        println("Se encontro los siguientes resultados: ")
        val resultado = libreta.filter { it.titulo.contains(busqueda, ignoreCase = true ) }

        cabecera()
        resultado.forEach {             
            formatoFila(it)
         }
        barra()
    }

    fun eliminarPorId(){
        println("Eliminar")
        tabla()
        print("Ingrese el ID: ")
        val id = readln().toIntOrNull() ?: return
        val eliminado = libreta.removeIf {it.id == id}
        if(eliminado) println("Nota eliminada correctamente.")
        else println("No ese encontró ninguna nota con ese ID.")
    }

    private fun tabla() {
        cabecera()
        libreta.forEach { 
           formatoFila(it)
        }
        barra()
    }

    private fun cabecera(){
        barra()
        println(encabezado)
        barra()
    }

    private fun barra() {
        val longitud = encabezado.length
        val barra = "=".repeat(longitud)
        println(barra)
    }

    private fun formatoFila(data: Nota){
        val formato = "%-2s %-10s %-30s %-30s".format(data.id, data.titulo, data.contenido, data.fecha)
        println(formato)   
    }
}

fun main(){   
    val repo = RepositorioNotas()
    do {
        println("==============Menú=============")
        println("1-Agregar")
        println("2-Listar")
        println("3-Buscar")
        println("4-Eliminar")
        println("5-Salir")
        println("===============================")
        print("Ingrese opcion: ")
        val opc = readln().toIntOrNull()

        when(opc) {
            1 -> repo.agregarNota()
            2 -> repo.listarNotas()
            3 -> repo.buscarPorTitulo()
            4 -> repo.eliminarPorId()
            else -> return
        }
    } while(opc != 5) 
}