package ru.freeit.googlemaps.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ru.freeit.googlemaps.R
import ru.freeit.googlemaps.databinding.MapFragmentBinding
import ru.freeit.location.LocationSimpleSingle

class GoogleMapFragment : CommonMapFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding = MapFragmentBinding.inflate(inflater, container, false)
        this.mapView = binding.mapView

        binding.mapView.onCreate(savedInstanceState)

        val locationSimple = LocationSimpleSingle(this)
        binding.locationButton.setOnClickListener {
            locationSimple.defineLocation { location ->
                binding.mapView.getMapAsync { googleMap ->
                    val latLng = LatLng(location.latitude, location.longitude)
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                    googleMap.addMarker(MarkerOptions().apply {
                        position(latLng)
                        title(getString(R.string.my_locaiton))
                    })
                }
            }
        }

        binding.mapView.getMapAsync { googleMap ->
            val sydney = LatLng(-34.0, 151.0)
            googleMap.addMarker(MarkerOptions().apply {
                position(sydney)
                title(getString(R.string.sydney))
            })
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }

        return binding.root
    }

}