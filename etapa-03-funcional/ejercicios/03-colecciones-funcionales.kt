fun main() {
    val numeros = listOf(1,2,3,4,5,6,7,8,9,10)
    println("=== Lista base ===")
    println(numeros)
    println("==================")

    // FILTRADO
    println("\n FILTRADO")
    val pares = numeros.filter { it % 2 == 0 }
    val impares = numeros.filterNot { it % 2 == 0 }
    val primeros3 = numeros.take(3)
    val sinPrimeros3 = numeros.drop(3)
    val sinDuplicados = listOf(1,2,3,3,4,4).distinct()
    val porBloques = numeros.chunked(3)

    // TRANSFROMACIÓN
    println("\n TRANSFORMACIÓN")
    val dobles = numeros.map { it * 2}
    val conIndice = numeros.mapIndexed { i,n -> "Pos[$i]=$n" }
    val texto = listOf("Hola Kotlin", "Programación funcional")
    val palabras = texto.flatMap { it.split(" ") }

    println("Dobles: $dobles")
    println("Con índice: $conIndice")
    println("Palabras planas (flatMap): $palabras")

    // AGREGACIÓN
    println("\n Agregación")
    val suma = numero.reduce { acc, n -> acc + n }
    val sumaConFold = numeros.fold(100) { acc, n -> acc + n }
    val promedio = numeros.average()
    val conteo = numeros.count { it > 5 }
    val maximo = numeros.maxByOrNull { it }
    val minimo = numeros.minByOrNull { it }

    println("Suma total: $suma")
    println("Suma con fold (inicio 100): $sumaConFold")
    println("Promedio: $promedio")
    println("Cantidad mayores que 5: $conteo")
    println("Máximo: $maximo | Mínimo: $minimo")

    // BÚSQUEDA
    println("\n BÚSQUEDA")
    val primeroPar = numeros.find { it % 2 == 0 }
    val ultimoImpar = numeros.last { it % 2 != 0 }
    val existeMayorQue10 = numeros.any { it > 0 }
    val todosPositivos = numeros.all { it > 0 }
    val ningunoNegativo = numeros.none { it < 0 }

    println("Primer par: $primeroPar")
    println("Último impar: $ultimoImpar")
    println("¿Alguno > 10? $existeMayorQue10")
    println("¿Todos positivos? $todosPositivos")
    println("¿Ninguno negativo? $ningunoNegativo")

    // ORGANIZACIÓN
    println("\n ORGANIZACIÓN")
    val desordenados = listOf(9,2,5,1,8,3)
    val ordenados = desordenados.sortedBy { it }
    val personas = listOf(
        Persona("Harold", 30),
        Persona("Lucía", 22),
        Persona("Pedro", 27),
        Persona("Anna", 30)
    )
    val agrupados = personas.groupBy { it.edad }
    val porNombre = personas.associateBy { it.nombre }
    val (menores, mayoresEdad ) = personas.partition { it.edad < 25 }

    println("Ordenados: $ordenados")
    println("Agrupados por edad: $agrupados")
    println("Asociados por nombre: $porNombre")
    println("Menores: $menores")
    println("Mayores: $mayoresEdad")

    // UNIÓN / DIVISIÓN
    println("\n UNIÓN / DIVISIÓN")
    val letras = listOf("A", "B", "C")
    val combinados = letras.zip(numeros)
    val unidos = numeros.plus(11)
    val sinAlgunos = numeros.minus(listOf(1, 2, 3))
    val listasAnidadas = listOf(listOf(1, 2), listOf(3,4), listOf(5))
    val listaPlana = listasAnidadas.flatten()

    println("Zip (letras + números): $combinados")
    println("Plus (agregar 11): $unidos")
    println("Minus (sin 1,2,3): $sinAlgunos")
    println("Flatten (listas anidadas -> planas): $listaPlana")
}

data class Persona(val nombre: String, val edad: Int)