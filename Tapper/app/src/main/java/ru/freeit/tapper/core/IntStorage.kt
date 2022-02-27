package ru.freeit.tapper.core

interface IntStorage {
    fun saveInt(key: String, value: Int)
    fun int(key: String, default: Int) : Int
}