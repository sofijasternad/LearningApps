package ru.freeit.notes.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.freeit.notes.R

class FragmentManagerWrapper(private val manager: FragmentManager) {
    fun replace(fragment: Fragment) {
        manager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}