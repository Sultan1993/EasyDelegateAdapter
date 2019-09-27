package kz.glatis.chocodevcon.core.regular

import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class KDelegateAdapter<T> : BaseDelegateAdapter<KDelegateAdapter.KViewHolder, T>() {

    open fun onCreated(view: View) = Unit

    abstract fun onBind(item: T, viewHolder: KViewHolder)

    override fun createViewHolder(parent: View) = KViewHolder(parent, ::onCreated)

    final override fun onBindViewHolder(view: View, item: T, viewHolder: KViewHolder) {
        onBind(item, viewHolder)
    }

    class KViewHolder(override val containerView: View, onCreated: (View) -> Unit) : BaseViewHolder(containerView), LayoutContainer {
        init {
            onCreated(containerView)
        }
    }
}