package ru.freeit.fadinglist.core.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup

abstract class ViewHolderWrapper<T> {

    abstract fun view(ctx: Context) : View

    private var listener: BindListener<T> = BindListener { _, _ -> }

    fun onBind(item: (pos: Int, item: T) -> Unit) {
        this.listener = BindListener(item)
    }

    fun holder(parent: ViewGroup) : CoreViewHolder<T> {
        val view = view(parent.context)
        return CoreViewHolder(view, listener)
    }


}