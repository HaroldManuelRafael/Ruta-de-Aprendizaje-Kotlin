object Configuracion {
    var modoOscuro: Boolean = false
    var idioma: String = "es"
    var version: String = "1.0.0"

    fun mostrar() {
        println("Configuración actual:")
        println("Modo oscuro: $modoOscuro")
        println("Idioma: $idioma")
        println("Versión: $version")
    }
}

fun main() {
    println("Primera lectura de configuración:")
    Configuracion.mostrar()

    println("\nCambiando valores globales...")
    Configuracion.modoOscuro = true
    Configuracion.idioma = "en"

    println("\nNueva configuración:")
    Configuracion.mostrar()
}