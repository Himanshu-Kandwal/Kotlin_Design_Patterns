package creational

import kotlin.concurrent.thread

fun main() {

    //instance 1
    val instance1 = SomeResource.getInstance()
    instance1.increaseCount()

    //instance 2
    val instance2 = SomeResource.getInstance()
    instance2.increaseCount()

    println("Synchronous incrementing : ${SomeResource.getInstance().getCount()}") //prints 2

    val threads = mutableListOf<Thread>()

    repeat(100) {
        val thread = Thread {
            // Your lambda code here
            SomeResource.getInstance().increaseCount()
        }
        threads.add(thread)
        thread.start()
    }

    threads.forEach { it.join() }

    println("After 100 threads incremented : ${SomeResource.getInstance().getCount()}") //prints 102

}

/*
If instance is null, create it, otherwise return it, and only one thread can access it at a time

Object Singleton vs This version

It can be subclassed i.e for mocking or different impl we can create child classes, Object singleton can not become parent.
 */
class SomeResource private constructor() {
    private var count = 0

    companion object {
        @Volatile
        private var instance: SomeResource? = null
        fun getInstance(): SomeResource =
            instance ?: synchronized(this) {
                instance ?: SomeResource().also { instance = it }
            }
    }

    fun increaseCount() {
        count++
    }

    fun getCount() = count
}
