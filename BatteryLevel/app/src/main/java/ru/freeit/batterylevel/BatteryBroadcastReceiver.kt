package ru.freeit.batterylevel

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryBroadcastReceiver(private val changeBatteryLevel: (intent: Intent) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        changeBatteryLevel(intent)
    }
}