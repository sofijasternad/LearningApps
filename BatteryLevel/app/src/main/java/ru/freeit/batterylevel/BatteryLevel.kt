package ru.freeit.batterylevel

import android.content.Intent
import android.os.BatteryManager
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import ru.freeit.batterylevel.ui.view.WaveView

class BatteryLevel(private val level: Int, private val isCharging: Boolean = false) {

    fun text(view: TextView?) {
        val chargingStatus = if (isCharging) {
            view?.resources?.getString(R.string.charging) ?: ""
        } else {
            view?.resources?.getString(R.string.not_charging) ?: ""
        }
        val str = "$level%\n$chargingStatus"
        view?.text = SpannableString(str).apply {
            setSpan(RelativeSizeSpan(0.6f),
                str.indexOf(chargingStatus),
                str.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }

    fun progress(view: WaveView?) { view?.setProgress(level) }

    companion object {
        fun from(intent: Intent) : BatteryLevel {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val chargingStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val isCharging = chargingStatus == BatteryManager.BATTERY_STATUS_CHARGING || chargingStatus == BatteryManager.BATTERY_STATUS_FULL
            val battery = level * 100 / scale.toFloat()
            return BatteryLevel(battery.toInt(), isCharging)
        }
    }

}