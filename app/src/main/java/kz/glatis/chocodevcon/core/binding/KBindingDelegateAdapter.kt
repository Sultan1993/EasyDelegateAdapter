package kz.glatis.chocodevcon.core.binding

import android.databinding.ViewDataBinding
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class KBindingDelegateAdapter<T> : BaseBindingDelegateAdapter<KBindingDelegateAdapter.KBindingViewHolder, T>() {

    open fun onCreated(binding: ViewDataBinding) = Unit

    abstract fun onBind(item: T, viewHolder: KBindingViewHolder)

    override fun createViewHolder(binding: ViewDataBinding) = KBindingViewHolder(binding, ::onCreated)

    override fun onBindViewHolder(binding: ViewDataBinding, item: T, viewHolder: KBindingViewHolder) {
        onBind(item, viewHolder)
    }

    class KBindingViewHolder(val binding: ViewDataBinding, onCreated: (ViewDataBinding) -> Unit) : BaseBindingViewHolder(binding), LayoutContainer {

        override val containerView: View = binding.root

        init {
            onCreated(binding)
        }
    }
}