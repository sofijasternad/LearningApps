package ru.freeit.ponylist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.ponylist.core.App
import ru.freeit.ponylist.databinding.ActivityMainBinding
import ru.freeit.ponylist.presentation.adapter.PonyAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter = PonyAdapter()
        binding.ponyList.adapter = adapter
        binding.ponyList.addItemDecoration(SpacingDecoration(20))

        val poniesModel = (application as App).ponies
        poniesModel.clearObservers()
        poniesModel.addObserver {  ponies ->
            adapter.submitList(ponies)
        }

        binding.addButton.setOnClickListener { poniesModel.add() }
        binding.removeButton.setOnClickListener { poniesModel.remove() }

    }
}