package kz.glatis.chocodevcon.core.diff

import android.support.v7.util.DiffUtil
import android.util.SparseArray
import kz.glatis.chocodevcon.core.base.CompositeDelegateAdapter
import kz.glatis.chocodevcon.core.base.IDelegateAdapter
import kz.glatis.chocodevcon.core.model.IAdapterComparableItem

open class DiffUtilCompositeAdapter(
        typeToAdapterMap: SparseArray<IDelegateAdapter<*, *>>
) : CompositeDelegateAdapter<IAdapterComparableItem>(typeToAdapterMap) {

    override fun swapData(newData: List<IAdapterComparableItem>) {
        DiffUtilDelegateCallback(data, newData).run {
            DiffUtil.calculateDiff(this).apply {
                data.run {
                    clear()
                    addAll(newData)
                }
                dispatchUpdatesTo(this@DiffUtilCompositeAdapter)
            }
        }
    }

    class Builder {

        private var count: Int = 0
        private val typeToAdapterMap: SparseArray<IDelegateAdapter<*, *>> = SparseArray()

        fun add(delegateAdapter: IDelegateAdapter<*, out IAdapterComparableItem>): Builder {
            typeToAdapterMap.put(count++, delegateAdapter)
            return this
        }

        fun build(): DiffUtilCompositeAdapter {
            if (count == 0) throw IllegalArgumentException("Register at least one adapter")
            return DiffUtilCompositeAdapter(typeToAdapterMap)
        }
    }
}