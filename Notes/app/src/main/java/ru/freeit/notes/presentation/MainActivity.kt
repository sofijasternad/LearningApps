package ru.freeit.notes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import ru.freeit.notes.R
import ru.freeit.notes.presentation.screens.note.NoteScreen
import ru.freeit.notes.presentation.screens.notes.NotesScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeBackButtonVisibility()

        supportFragmentManager.addOnBackStackChangedListener { changeBackButtonVisibility() }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, NotesScreen())
                .commit()
        }
    }

    private fun changeBackButtonVisibility() {
        val fragments = supportFragmentManager.fragments
        if (fragments.isEmpty())
            return
        val currentFragment = fragments.last()
        if (currentFragment is NoteScreen) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}