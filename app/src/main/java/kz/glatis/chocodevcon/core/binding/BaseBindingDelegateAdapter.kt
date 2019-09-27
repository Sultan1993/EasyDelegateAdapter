package kz.glatis.chocodevcon.core.binding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.glatis.chocodevcon.core.base.IDelegateAdapter


abstract class BaseBindingDelegateAdapter<VH : BaseBindingViewHolder, T> : IDelegateAdapter<VH, T> {

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun onBindViewHolder(binding: ViewDataBinding, item: T, viewHolder: VH)

    /**
     * @param parent inflated view
     */

    protected abstract fun createViewHolder(binding: ViewDataBinding): VH

    override fun onRecycled(holder: VH) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                layoutId, parent, false) as ViewDataBinding

        return createViewHolder(binding).apply {
            setListener(object : BaseBindingViewHolder.ItemBindingInflateListener {
                override fun inflated(viewType: Any, binding: ViewDataBinding) {
                    onBindViewHolder(binding, viewType as T, this@apply)
                }
            })
        }
    }

    override fun onBindViewHolder(holder: VH, items: List<T>, position: Int) {
        (holder as BaseBindingViewHolder).bind(items[position] as Any)
    }
}