package task_1

import java.util.*

private const val SECONDS_GAP = 3
private const val MILLIS_IN_SECOND = 1000

fun main() {

    // Delegated property
    var cacheValue: Long by propertyDelegateProvider
    cacheValue = System.currentTimeMillis()

    // Delegate
    val cache: TimeCache = TimeCacheDelegate(TimeCacheImpl())
        .also { it.saveTime(System.currentTimeMillis()) }

    val calendar = Calendar.getInstance().apply { timeInMillis = cacheValue }
    val startTimeToPrint = calendar.time

    var previousTime = calendar.timeInMillis

    val runnable = Runnable {
        while (true) {
            if (!Thread.interrupted()) {
                if (checkTimeGap(previousTime)) {

                    println("Start time: $startTimeToPrint")

                    previousTime = System.currentTimeMillis()
                    calendar.timeInMillis = previousTime

                    println("Current time: ${calendar.time}")
                }
            }
        }
    }

    val thread = Thread(runnable)
    thread.start()

}

private fun checkTimeGap(prevTime: Long): Boolean {
    return (System.currentTimeMillis() - prevTime) / MILLIS_IN_SECOND >= SECONDS_GAP
}