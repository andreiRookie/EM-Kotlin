package task_3

fun main() {

    println("Unsorted list:\n$listToSort")

    val sortedList = with(ShakerSorter(listToSort)) {
        toSort()
    }
    println("Sorted list:\n$sortedList")

}

context(ShakerSorter)
fun toSort(): List<Int?> {
    return shakerSort()
}

private val listToSort: List<Int?> = listOf(
    1, null, null, 1234, null, null, 22222, 3434, 50000, null, 66,
    100, null, null, 555, null, 777, 12, null, null
)