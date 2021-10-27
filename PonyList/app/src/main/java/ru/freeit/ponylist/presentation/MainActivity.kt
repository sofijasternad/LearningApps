package ru.freeit.ponylist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.ponylist.databinding.ActivityMainBinding
import ru.freeit.ponylist.presentation.adapter.PonyAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        val adapter = PonyAdapter()
        binding.ponyList.adapter = adapter

    }
}