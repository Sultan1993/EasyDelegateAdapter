package kz.glatis.chocodevcon.core.diff

import android.support.v7.util.DiffUtil
import kz.glatis.chocodevcon.core.model.IAdapterComparableItem

class DiffUtilDelegateCallback(private val oldList: List<IAdapterComparableItem>,
                               private val newList: List<IAdapterComparableItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id() == newList[newItemPosition].id()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].content() == newList[newItemPosition].content()

}