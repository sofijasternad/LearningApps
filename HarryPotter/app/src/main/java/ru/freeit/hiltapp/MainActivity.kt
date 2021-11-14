package ru.freeit.hiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chapterName = findViewById<TextView>(R.id.chapter_name)
        val chapterContent = findViewById<TextView>(R.id.chapter_content)

        viewModel.observe(this) { chapterUi ->
            chapterUi.name(chapterName)
            chapterUi.content(chapterContent)
        }

        viewModel.init()

    }

}