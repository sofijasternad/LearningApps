package ru.freeit.ponylist.core

import android.app.Application
import ru.freeit.ponylist.model.Ponies

class App : Application() {

    private val ponies by lazy { Ponies() }

}