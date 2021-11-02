package ru.freeit.googlemaps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.freeit.googlemaps.R
import ru.freeit.googlemaps.ui.screens.GoogleMapFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, GoogleMapFragment())
                .commit()
        }

    }
}