package ru.freeit.personalapp

import android.content.Intent
import android.net.Uri
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

            // создаем Intent чтобы открыть любую ссылку (в данном случае ссылка на мой чатик в телеграме)
            val link = "https://t.me/freeit256"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(link)
            startActivity(intent)

            // показываем всплывающее сообщение внизу экрана
//            Snackbar.make(root, R.string.subscribed, Snackbar.LENGTH_SHORT).show()
        }
    }
}