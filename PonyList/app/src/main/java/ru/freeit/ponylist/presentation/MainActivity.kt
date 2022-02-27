package ru.freeit.ponylist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import ru.freeit.ponylist.core.App
import ru.freeit.ponylist.databinding.ActivityMainBinding
import ru.freeit.ponylist.presentation.adapter.PonyAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // use ViewBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create RecyclerView adapter
        val adapter = PonyAdapter()

        // setup RecyclerView
        binding.ponyList.adapter = adapter
        // add ItemAnimator
        binding.ponyList.itemAnimator = SlideInRightAnimator()
        // add ItemDecoration
        binding.ponyList.addItemDecoration(SpacingDecoration(20))

        // get our model
        val poniesModel = (application as App).ponies

        // clear old observers and add a new observer
        poniesModel.clearObservers()
        poniesModel.addObserver(adapter::submitList)

        // change our model
        binding.addButton.setOnClickListener { poniesModel.add() }
        binding.removeButton.setOnClickListener { poniesModel.remove() }
    }
}