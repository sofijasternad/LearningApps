package ru.freeit.tapper.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.tapper.core.SavedSharedPreferences
import ru.freeit.tapper.databinding.ActivityMainBinding
import ru.freeit.tapper.model.Count
import ru.freeit.tapper.presentation.anim.SimpleAnimator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countModel = Count(SavedSharedPreferences(this)) { number ->
            SimpleAnimator(binding.numberText).scaleBoth(300,
                { binding.numberText.text = number.toString() },
                1f, 1.3f, 1f)
        }

        binding.addButton.setOnClick {
            SimpleAnimator(it).scaleBoth(300, {}, 1f, 1.1f, 1f)
            binding.bounceAppearingView.appear()
            countModel.increment()
        }

    }
}