fun main() {
    println("Inicio del programa (hilo principal)")

    val hilo1 = Thread{
        for (i in 1..5){
            println("Hilo 1 -> paso $i")
            Thread.sleep(500)
        }
    }

    val hilo2 = Thread {
        for (i in 1..5) {
            println("Hilo 2 -> paso $i")
            Thread.sleep(700)
        }
    }

    hilo1.start()
    hilo2.start()

    println("Hilos iniciados...")

    hilo1.join()
    hilo2.join()

    println("Fin del programa (hilo principal)")
}