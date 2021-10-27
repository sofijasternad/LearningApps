package ru.freeit.ponylist.model

import ru.freeit.ponylist.R

class Ponies(private val observer: (ponies: List<Pony>) -> Unit) {
    private val allPonies = listOf(
        Pony(
            id = 0,
            title = R.string.starlight_glimmer,
            img = R.drawable.starlight,
            type = R.string.unicorn
        ),
        Pony(
            id = 0,
            title = R.string.twillight_sparkle,
            img = R.drawable.twillight,
            type = R.string.alicorn
        ),
        Pony(id = 0, title = R.string.rarity, img = R.drawable.rarity, type = R.string.unicorn),
        Pony(
            id = 0,
            title = R.string.starswirl,
            img = R.drawable.starswirl,
            type = R.string.unicorn
        ),
        Pony(
            id = 0,
            title = R.string.apple_jack,
            img = R.drawable.apple_jack,
            type = R.string.ground_pony
        ),
        Pony(
            id = 0,
            title = R.string.fluttershy,
            img = R.drawable.fluttershy,
            type = R.string.pegasus
        ),
        Pony(
            id = 0,
            title = R.string.rainbow_dash,
            img = R.drawable.rainbow,
            type = R.string.pegasus
        ),
        Pony(
            id = 0,
            title = R.string.pinky_pie,
            img = R.drawable.pinky,
            type = R.string.ground_pony
        ),
    )
    private val ponies = mutableListOf(
        Pony(
            id = 0,
            title = R.string.starlight_glimmer,
            img = R.drawable.starlight,
            type = R.string.unicorn
        )
    )

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

    private fun notifyObserver() {
        observer.invoke(ponies)
    }

}