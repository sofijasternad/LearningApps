package ru.freeit.tapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.freeit.tapper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClick {
            binding.bounceAppearingView.appear()
        }

    }
}