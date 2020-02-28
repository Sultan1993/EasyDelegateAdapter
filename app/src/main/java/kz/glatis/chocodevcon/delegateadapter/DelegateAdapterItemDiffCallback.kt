package kz.glatis.chocodevcon.delegateadapter

import android.support.v7.util.DiffUtil

internal class DelegateAdapterItemDiffCallback: DiffUtil.ItemCallback<DelegateAdapterItem>() {

    override fun areItemsTheSame(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Boolean =
            oldItem::class == newItem::class && oldItem.id() == newItem.id()

    override fun areContentsTheSame(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Boolean =
            oldItem.content() == newItem.content()

    override fun getChangePayload(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Any =
            oldItem.payload(newItem)
}