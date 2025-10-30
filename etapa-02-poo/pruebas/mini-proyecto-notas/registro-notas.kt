

data class Nota (val id: Int, val titulo: String, val contenido: String, val fecha: String)

class RepositorioNotas() {

    private val libreta = mutableListOf<Nota>()

    fun agregarNota(){
        val aumento = 1
        val cantidadDeNotas = libreta.size
        val indice = cantidadDeNotas + aumento

        print("Ingrese título: ")
        val titulo = readln().toString()
        print("Ingrese contenido: ")
        val contenido = readln().toString()
        print("Ingrese fecha: ")
        val fecha = readln().toString()

        val nota = Nota(indice,titulo,contenido,fecha)
        libreta.add(nota)
        println("Se registro la nota $titulo.[Total: ${libreta.size}]")
    }
    fun listarNotas(){
        println("Se esta listando las notas")
        println(libreta)
    }
    fun buscarPorTitulo(){
        println("Se busca por titulo")
    }
    fun eliminarPorId(){
        println("Se esta eliminando")
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