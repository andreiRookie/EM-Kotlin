package task_2

import kotlin.reflect.KClass


fun main() {

    while (true) {
        println("Input \"ONE\" to find one Int, \"FEW\" to find few, any other to find by class and exit")
        val input = readln().uppercase()

        val inputValue = try {
            InputValue.valueOf(input)
        } catch (e: Exception) {
            InputValue.ANY_OTHER
        }

        when (inputValue) {
            InputValue.ONE -> {
                val int = list.findInt()
                println(int)
            }

            InputValue.FEW -> {
                val ints = list.findFew()
                println(ints)
            }

            InputValue.ANY_OTHER -> {
                println("find class Char: ${list.findByClass(Char::class)}")
                println("find class List: ${list.findByClass(List::class)}")
                println("find class Double: ${list.findByClass(Double::class)}")
                println("Bye bye")
                break
            }
        }
    }
}

private enum class InputValue {
    ONE, FEW, ANY_OTHER
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