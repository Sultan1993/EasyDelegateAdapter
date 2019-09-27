package kz.glatis.chocodevcon.core.binding

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class BaseBindingViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    private var listener: ItemBindingInflateListener? = null

    fun setListener(listener: ItemBindingInflateListener) {
        this.listener = listener
    }

    fun bind(item: Any) {
        listener?.inflated(item, binding)
    }

    interface ItemBindingInflateListener {
        fun inflated(viewType: Any, binding: ViewDataBinding)
    }
}