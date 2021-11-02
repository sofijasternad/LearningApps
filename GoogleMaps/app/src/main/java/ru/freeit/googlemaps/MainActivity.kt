package ru.freeit.googlemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val supportMapFragment = SupportMapFragment()
        supportMapFragment.getMapAsync { googleMap ->
            val sydney = LatLng(-34.0, 151.0)
            googleMap.addMarker(MarkerOptions().apply {
                position(sydney)
                title(getString(R.string.sydney))
            })
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, supportMapFragment)
                .commit()
        }

    }
}