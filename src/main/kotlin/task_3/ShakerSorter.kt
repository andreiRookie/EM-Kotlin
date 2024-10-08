package task_3

class ShakerSorter(
    private val list: List<Int?>?
) {

    fun shakerSort(): List<Int?> {
        val resultList = requireNotNull(list) { "List must not be null" }.toMutableList()

        // list borders
        var listStartMark = 0
        var listEndMark = resultList.size - 1

        while (listStartMark <= listEndMark) {

            // from end to start
            for (i in listEndMark downTill listStartMark) {
                when {
                    resultList[i - 1] == null -> {
                        resultList.swap(iOld = i - 1, iNew = i)
                        continue
                    }

                    resultList[i] != null && resultList[i - 1]!! > resultList[i]!! -> {
                        resultList.swap(iOld = i - 1, iNew = i)
                        continue
                    }
                }
            }
            listStartMark++

            // from start to end
            for (i in listStartMark until listEndMark) {

                when {
                    resultList[i] == null -> {
                        resultList.swap(iOld = i, iNew = i + 1)
                        continue
                    }

                    resultList[i + 1] != null && resultList[i]!! > resultList[i + 1]!! -> {
                        resultList.swap(iOld = i, iNew = i + 1)
                        continue
                    }
                }
            }
            listEndMark--

            println("Iteration ${listStartMark - 1}")
        }

        return resultList
    }

    private infix fun Int.downTill(till: Int): IntProgression {
        if (till >= Int.MAX_VALUE) return IntRange.EMPTY
        return this downTo till + 1
    }

    private fun MutableList<Int?>.swap(iOld: Int, iNew: Int) {
        val buffer = this[iOld]
        this[iOld] = this[iNew]
        this[iNew] = buffer
    }
}