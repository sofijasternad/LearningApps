package ru.freeit.tapper.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.tapper.core.LocalStorage
import ru.freeit.tapper.databinding.ActivityMainBinding
import ru.freeit.tapper.model.Count
import ru.freeit.tapper.presentation.anim.SimpleAnimator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // use ViewBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create observer
        val observer = { number: Int ->
            // start animation
            SimpleAnimator(binding.numberText).scaleBoth(duration = 300, onEnd = {
                // apply number as text when the animation is over
                binding.numberText.text = number.toString()
            },1f, 1.3f, 1f)
        }

        // create our model Count
        val countModel = Count(LocalStorage(this), observer)

        binding.addButton.setOnClickListener { button ->
            // apply animation
            SimpleAnimator(button).scaleBoth(300, {}, 1f, 1.1f, 1f)
            // make beautiful effect
            binding.bounceAppearingView.appear()
            // change model
            countModel.increment()
        }

    }

}