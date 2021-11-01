package ru.freeit.myposts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.freeit.myposts.R
import ru.freeit.myposts.ui.screens.posts.PostsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, PostsFragment())
                .commit()
        }
    }
}