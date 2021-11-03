package ru.freeit.notes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.freeit.notes.R
import ru.freeit.notes.presentation.screens.notes.NotesScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, NotesScreen())
                .commit()
        }
    }
}