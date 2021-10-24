package ru.freeit.personalapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = Name(this).str()

        val root = findViewById<View>(R.id.root)

        findViewById<Button>(R.id.subscribe_button).setOnClickListener {
            Snackbar.make(root, R.string.subscribed, Snackbar.LENGTH_SHORT).show()
        }
    }
}