package ru.freeit.ponylist.core

import android.app.Application
import ru.freeit.ponylist.model.Ponies

class App : Application() {

    // we use App lifetime to handle configuration changes
    val ponies by lazy { Ponies() }

}