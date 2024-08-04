package task_2

import kotlin.reflect.KClass


fun main() {

    while (true) {
        println("Input \"1\" to find one Int, \"2\" to find few, any other to exit")
        val input = readln()

        when (input) {
            "1" -> {
                val int = list.findInt()
                println(int)
            }

            "2" -> {
                val ints = list.findFew()
                println(ints)
            }
            else -> {
                println("findClass(Char::class): ${list.findByClass(Char::class)}")
                println("findClass(List::class): ${list.findByClass(List::class)}")
                println("findClass(Double::class): ${list.findByClass(Double::class)}")
                println("Bye bye")
                break
            }
        }
    }

}

private inline fun <reified T : Any> List<T>.findInt(): Int {
    return this.first { it is Int } as Int
}

private inline fun <reified T : Any> List<T>.findFew(): List<Int> {
    return this.filter { it is Int }.map { it as Int }
}

private inline fun <reified T : Any> List<T>.findByClass(kClass: KClass<out T>): T {
    return this.first { kClass.isInstance(it) }
}

private val list: List<Any> = listOf(
    100.00, '$', 555, "Kotlin", 1234, listOf(10, 20, 30, 40), 22222, 'K', 50000
)