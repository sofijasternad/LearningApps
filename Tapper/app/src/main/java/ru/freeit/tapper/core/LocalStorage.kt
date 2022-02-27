package ru.freeit.tapper.core

import android.content.Context

class LocalStorage(ctx: Context) : IntStorage {
    private val sharedPrefs = ctx.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    override fun saveInt(key: String, value: Int) {
        sharedPrefs.edit().putInt(key, value).apply()
    }
    override fun int(key: String, default: Int) : Int {
        return sharedPrefs.getInt(key, default)
    }
}