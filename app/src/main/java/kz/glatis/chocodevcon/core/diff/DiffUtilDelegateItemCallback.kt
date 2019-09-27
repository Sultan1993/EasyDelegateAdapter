package kz.glatis.chocodevcon.core.diff

import android.support.v7.util.DiffUtil
import kz.glatis.chocodevcon.core.model.IAdapterComparableItem

class DiffUtilDelegateItemCallback : DiffUtil.ItemCallback<IAdapterComparableItem>() {

    override fun areItemsTheSame(oldItem: IAdapterComparableItem, newItem: IAdapterComparableItem): Boolean =
            oldItem.id() == newItem.id()

    override fun areContentsTheSame(oldItem: IAdapterComparableItem, newItem: IAdapterComparableItem): Boolean =
            oldItem.content() == newItem.content()

}