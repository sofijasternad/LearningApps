package ru.freeit.tapper.model

import org.junit.Assert.*
import org.junit.Test
import ru.freeit.tapper.core.IntStorage

class CountTest {

    private inner class TestStorage : IntStorage {
        var int = 0

        override fun int(key: String, default: Int): Int {
            return int
        }

        override fun saveInt(key: String, value: Int) {
            this.int = value
        }
    }

    @Test
    fun test_created() {
        Count(TestStorage()) { value ->
            assertEquals(0, value)
        }
    }

    @Test
    fun test_increment() {
        val storage = TestStorage()
        val count = Count(storage) {}
        count.increment()
        count.increment()
        assertEquals(2, storage.int)
    }

    @Test
    fun test_saved() {
        val storage = TestStorage()
        storage.int = 10
        Count(storage) { value ->
            assertEquals(10, value)
        }
    }

}