package ru.freeit.batterylevel

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.batterylevel.ui.view.WaveView

class MainActivity : AppCompatActivity() {

    private var batteryLevelProgress: WaveView? = null
    private var batteryLevelText: TextView? = null

    private val receiver = BatteryBroadcastReceiver(::changeBatteryLevel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.batteryLevelProgress = findViewById(R.id.battery_level_progress)
        this.batteryLevelText = findViewById(R.id.battery_level_text)
    }

    private fun changeBatteryLevel(intent: Intent) {
        BatteryLevel.from(intent).apply {
            text(batteryLevelText)
            progress(batteryLevelProgress)
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))?.let(::changeBatteryLevel)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}