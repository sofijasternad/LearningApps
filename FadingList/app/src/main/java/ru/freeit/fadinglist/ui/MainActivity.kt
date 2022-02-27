package ru.freeit.fadinglist.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.freeit.fadinglist.core.*
import ru.freeit.fadinglist.core.adapter.ViewHolderWrapper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(frameLayout {
            addView(list {
                linearVertical()

                val source = HeroSource()

                // look at my article: https://habr.com/en/post/652687/ (Russian)
                adapter(source.heroes(), object: ViewHolderWrapper<Hero>() {
                    override fun view(ctx: Context): View {
                        return HeroListItemView(ctx, ::onBind)
                    }
                })
            })
        })

    }
}