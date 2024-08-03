package task_1

import kotlin.reflect.KProperty


interface TimeCache {
    fun saveTime(timeInMillis: Long)
    fun getTime(): Long
}

class TimeCacheImpl : TimeCache {

    private var cache = 0L

    override fun saveTime(timeInMillis: Long) {
        cache = timeInMillis
    }

    override fun getTime(): Long = cache
}

class TimeCacheDelegate(cache: TimeCache): TimeCache by cache

class TimeCachePropertyDelegate(
    private val timeCache: TimeCache
) {
    operator fun getValue(cache: Any?, property: KProperty<*>): Long = timeCache.getTime()
    operator fun setValue(cache: Any?, property: KProperty<*>, newValue: Long) {
        timeCache.saveTime(newValue)
    }
}
