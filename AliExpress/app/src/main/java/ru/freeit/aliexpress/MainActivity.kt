package ru.freeit.aliexpress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.ali_express_web_view)
        webView.loadUrl("aliexpress.ru")
        webView.settings.javaScriptEnabled = true
    }
}