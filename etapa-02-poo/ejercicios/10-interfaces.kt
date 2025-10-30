// Una interfaz define un contrato: qué métodos deben existir
interface Exportable {
    fun exportar(): String
}

// Clase base común
open class Documento(val titulo: String)

// Cada clase implementa la interfaz a su manera
class Informe(titulo: String, val contenido: String) : Documento(titulo), Exportable {
    override fun exportar(): String {
        return "📄 Exportando informe '$titulo' con $contenido"
    }
}

class Imagen(titulo: String, val resolucion: String) : Documento(titulo), Exportable {
    override fun exportar(): String {
        return "🖼️ Exportando imagen '$titulo' en resolución $resolucion"
    }
}

class Video(titulo: String, val duracion: Int) : Documento(titulo), Exportable {
    override fun exportar(): String {
        return "🎞️ Exportando video '$titulo' de $duracion segundos"
    }
}

fun main() {
    val archivos: List<Exportable> = listOf(
        Informe("Reporte Mensual", "20 páginas"),
        Imagen("Logo", "1080p"),
        Video("Spot Publicitario", 45)
    )

    for (archivo in archivos) {
        println(archivo.exportar())
    }
}
