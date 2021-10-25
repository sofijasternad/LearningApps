package ru.freeit.tapper

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import ru.freeit.tapper.databinding.ActivityMainBinding

interface IntPrefs {
    fun saveInt(key: String, value: Int)
    fun int(key: String, default: Int) : Int
}

class SavedSharedPreferences(private val ctx: Context) : IntPrefs {
    private val sharedPrefs = ctx.getSharedPreferences("app_prefs", MODE_PRIVATE)

    override fun saveInt(key: String, value: Int) {
        sharedPrefs.edit().putInt(key, value).apply()
    }
    override fun int(key: String, default: Int) : Int {
        return sharedPrefs.getInt(key, default)
    }
}

class Count(private val intPrefs: IntPrefs, private val countObserver: (count: Int) -> Unit) {
    private var count: Int = 0

    companion object {
        private const val countKey = "count_key"
    }

    init {
        count = intPrefs.int(countKey, 0)
        notifyObservers()
    }

    fun increment() {
        count++
        notifyObservers()
        intPrefs.saveInt(countKey, count)
    }

    private fun notifyObservers() {
        countObserver.invoke(count)
    }

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller = Count(SavedSharedPreferences(this)) { number ->
            val scaleX = ObjectAnimator.ofFloat(binding.numberText, View.SCALE_X, 1f, 1.3f, 1f)
            val scaleY = ObjectAnimator.ofFloat(binding.numberText, View.SCALE_Y, 1f, 1.3f, 1f)
            val animSet = AnimatorSet().apply {
                duration = 300
                playTogether(scaleX, scaleY)
                doOnEnd {
                    binding.numberText.text = number.toString()
                }
                start()
            }
        }

        binding.addButton.setOnClick {
            val scaleX = ObjectAnimator.ofFloat(it, View.SCALE_X, 1f, 1.1f, 1f)
            val scaleY = ObjectAnimator.ofFloat(it, View.SCALE_Y, 1f, 1.1f, 1f)
            val animSet = AnimatorSet().apply {
                duration = 300
                playTogether(scaleX, scaleY)
                start()
            }
            binding.bounceAppearingView.appear()
            controller.increment()
        }

    }
}