package ru.freeit.fadinglist.core

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


abstract class ViewHolderWrapper<T> {

    abstract fun view(ctx: Context) : View

    private var listener: ItemBindListener<T>? = null

    fun listenItem(item: (pos: Int, item: T) -> Unit) : ItemBindListener<T>  {
        this.listener = ItemBindListener<T>(item)
        return listener!!
    }

    fun holder(parent: ViewGroup) : CoreViewHolder<T> {
        val view = view(parent.context)
        return CoreViewHolder(view, listener ?: ItemBindListener<T> { _, _ -> })
    }


}

fun interface ItemBindListener<T> {
    fun onBind(pos: Int, item: T)
}

class CoreViewHolder<T>(view: View, private val listener: ItemBindListener<T>) : RecyclerView.ViewHolder(view) {
    fun bind(position: Int, item: T) { listener.onBind(position, item) }
}

class CoreAdapter<T>(
    private val items: List<T>,
    private val viewHolderWrapper: ViewHolderWrapper<T>
) : RecyclerView.Adapter<CoreViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolderWrapper.holder(parent)
    override fun onBindViewHolder(holder: CoreViewHolder<T>, position: Int) = holder.bind(position, items[position])
    override fun getItemCount() = items.size

}