package task_1

import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty


interface TimeCache {
    fun saveTime(timeInMillis: Long)
    fun getTime(): Long
}

private const val INITIAL_DEFAULT_CACHE_VALUE = 0L

class TimeCacheImpl : TimeCache {

    private var cache = INITIAL_DEFAULT_CACHE_VALUE

    override fun saveTime(timeInMillis: Long) {
        cache = timeInMillis
    }

    override fun getTime(): Long = cache
}

class TimeCacheDelegate(cache: TimeCache): TimeCache by cache

class TimeCachePropertyDelegate(
    private val timeCache: TimeCache
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long = timeCache.getTime()
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Long) {
        timeCache.saveTime(newValue)
    }
}

val propertyDelegateProvider = PropertyDelegateProvider { thisRef: Any?, prop: KProperty<*> ->
    TimeCachePropertyDelegate(TimeCacheImpl())
}

class TimeCachePropertyDelegateProvider {
    operator fun provideDelegate(thisRef: Any?, prop: KProperty<*>): TimeCachePropertyDelegate {
        return TimeCachePropertyDelegate(TimeCacheImpl())
    }
}
