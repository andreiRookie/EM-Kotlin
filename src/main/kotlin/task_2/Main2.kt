package task_2


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
                println("Bye bye")
                break
            }
        }
    }

}

private inline fun <reified T> List<T>.findInt(): Int {
    return this.first { it is Int } as Int
}

private inline fun <reified T> List<T>.findFew(): List<Int> {
    return this.filter { it is Int }.map { it as Int }
}

private val list: List<Any?> = listOf(
    100.00, null, '$', 555, "Kotlin", 1234, emptyList<Int>(), 22222, 'K', 50000
)