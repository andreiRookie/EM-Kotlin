package task_1


interface TimeCache {
    fun saveTime(time: Long)
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
