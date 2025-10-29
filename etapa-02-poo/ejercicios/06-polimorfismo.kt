open class Empleado(
    val nombre: String,
    val salario: Double
) {
    open fun calcularBono(): Double {
        return salario * 0.05
    }

    open fun mostrarInfo() {
        println("Empleado: $nombre | Salario: S/ ${"%.2f".format(salario)} | Bono: S/ ${"%.2f".format(calcularBono())}")
    }
}

class Gerente(nombre: String, salario: Double, val equipo: Int) : Empleado(nombre, salario) {
    override fun calcularBono(): Double {
        return salario * 0.15
    }

    override fun mostrarInfo() {
        println("Gerente: $nombre | Equipo: $equipo | Salario: S/ ${"%.2f".format(salario)} | Bono: S/ ${"%.2f".format(calcularBono())}")
    }
}

class Vendedor(nombre: String, salario: Double, val ventas: Int) : Empleado(nombre, salario) {
    override fun calcularBono(): Double {
        return salario * 0.10 + (ventas * 2)
    }

    override fun mostrarInfo() {
        println("Vendedor: $nombre | Ventas: $ventas | Salario: S/ ${"%.2f".format(salario)} | Bono: S/ ${"%.2f".format(calcularBono())}")
    }
}

fun main() {
    val e1 = Empleado("Carlos",1500.0)
    val g1 = Gerente("María", 2500.0, 8)
    val v1 = Vendedor("Luis", 1200.0, 35)

    val empleados = listOf(e1,g1,v1)

    println("=== Nómina ===")
    for (emp in empleados) {
        emp.mostrarInfo()
    }
}


