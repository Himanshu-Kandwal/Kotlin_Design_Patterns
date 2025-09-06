package org.hk.creational

/*
Singleton - Only one object as long as app lives.

This sample uses Kotlin’s object declaration, which creates exactly one instance per classloader and is concise for global resources
 */
object DummyDatabase {
    private val record = mutableSetOf<String>() //dummy storage of records

    fun add(str: String) {
        record.add(str)
    }

    fun remove(str: String) {
        record.remove(str)
    }

    fun print() {
        for (item in record)
            println(item)
    }
}

//usage

fun main() {
    DummyDatabase.add("hello")
    DummyDatabase.add("Bye")
    DummyDatabase.print()
}