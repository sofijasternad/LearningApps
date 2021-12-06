package ru.freeit.fadinglist.ui

import ru.freeit.fadinglist.R

class HeroSource {
    private val items = listOf(
        Hero(R.string.canan, R.drawable.canan),
        Hero(R.string.ezra, R.drawable.ezra),
        Hero(R.string.sabin, R.drawable.sabin),
        Hero(R.string.zeb, R.drawable.zeb)
    )

    fun heroes() = items
}