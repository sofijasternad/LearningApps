package ru.freeit.batterylevel

import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView
import ru.freeit.batterylevel.ui.view.WaveView

class BatteryLevel(private val level: Int) {

    fun text(view: TextView?) { view?.text = "$level%" }
    fun progress(view: WaveView?) { view?.setProgress(level) }

    companion object {
        fun from(intent: Intent) : BatteryLevel {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val battery = level * 100 / scale.toFloat()
            return BatteryLevel(battery.toInt())
        }
    }


}