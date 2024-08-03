package task_1

import java.util.*

private const val SECONDS_GAP = 3

fun main() {

    val cache: TimeCache = TimeCacheDelegate(TimeCacheImpl())
        .also { it.saveTime(System.currentTimeMillis()) }

    val calendar = Calendar.getInstance().apply { timeInMillis = cache.getTime() }
    val startTimeToPrint = calendar.time

    var previousTime = calendar.timeInMillis

    val runnable = Runnable {
        while (true) {
            if (!Thread.interrupted()) {
                if (((System.currentTimeMillis() - previousTime) / 1000) >= SECONDS_GAP) {

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