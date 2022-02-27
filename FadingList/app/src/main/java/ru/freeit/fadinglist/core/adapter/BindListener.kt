`package ru.freeit.fadinglist.core.adapter

fun interface BindListener<T> {
    fun onBind(pos: Int, item: T)
}