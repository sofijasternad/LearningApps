package ru.freeit.ponylist.model

import ru.freeit.ponylist.R

class Ponies {

    private val observers = mutableListOf<(ponies: List<Pony>) -> Unit>()

    private val allPonies = listOf(
        Pony(
            id = 0,
            title = R.string.starlight_glimmer,
            img = R.drawable.starlight,
            family = R.string.unicorn
        ),
        Pony(
            id = 1,
            title = R.string.twillight_sparkle,
            img = R.drawable.twillight,
            family = R.string.alicorn
        ),
        Pony(
            id = 2,
            title = R.string.rarity,
            img = R.drawable.rarity,
            family = R.string.unicorn
        ),
        Pony(
            id = 3,
            title = R.string.starswirl,
            img = R.drawable.starswirl,
            family = R.string.unicorn
        ),
        Pony(
            id = 4,
            title = R.string.apple_jack,
            img = R.drawable.apple_jack,
            family = R.string.ground_pony
        ),
        Pony(
            id = 5,
            title = R.string.fluttershy,
            img = R.drawable.fluttershy,
            family = R.string.pegasus
        ),
        Pony(
            id = 6,
            title = R.string.rainbow_dash,
            img = R.drawable.rainbow,
            family = R.string.pegasus
        ),
        Pony(
            id = 7,
            title = R.string.pinky_pie,
            img = R.drawable.pinky,
            family = R.string.ground_pony
        ),
    )

    private val ponies = mutableListOf(allPonies.first())

    fun add() {
        if (ponies.size < allPonies.size) {
            ponies.add(allPonies[ponies.size])
            notifyObserver()
        }
    }

    fun remove() {
        if (ponies.isNotEmpty()) {
            ponies.removeLast()
            notifyObserver()
        }
    }

    fun addObserver(observer: (items: List<Pony>) -> Unit) {
        observers.add(observer)
        notifyObserver()
    }

    fun clearObservers() = observers.clear()

    private fun notifyObserver() {
        val copiedPonies = ponies.toList()
        observers.forEach { observer -> observer.invoke(copiedPonies) }
    }

}