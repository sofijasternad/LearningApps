package ru.freeit.fadinglist.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.fadinglist.core.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val parent = frameLayout(this) {}

        setContentView(parent)

        val source = HeroSource()

        parent.addView(listView(this) {
            linearVertical()
            adapter(source.heroes(), object: ViewHolderWrapper<Hero>() {
                override fun view(ctx: Context) = HeroListItemView(ctx, ::listenItem)
            })
        })

    }
}