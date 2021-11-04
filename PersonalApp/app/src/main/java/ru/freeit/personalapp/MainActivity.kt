package ru.freeit.personalapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

/**
 * главный компонент почти любого приложения,
 * которое имеет пользовательский интерфейс
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // меняем заголовок тулбара на наше имя со смайликами
        supportActionBar?.title = Name(this).str()

        val root = findViewById<View>(R.id.root)

        // обработка нажатия кнопки
        findViewById<Button>(R.id.subscribe_button).setOnClickListener {
            // показываем всплывающее сообщение внизу экрана
            Snackbar.make(root, R.string.subscribed, Snackbar.LENGTH_SHORT).show()
        }
    }
}