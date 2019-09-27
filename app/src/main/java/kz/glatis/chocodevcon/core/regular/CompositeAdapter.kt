package kz.glatis.chocodevcon.core.regular

import android.util.SparseArray
import kz.glatis.chocodevcon.core.base.CompositeDelegateAdapter
import kz.glatis.chocodevcon.core.base.IDelegateAdapter
import kz.glatis.chocodevcon.core.diff.IAdapterItem


open class CompositeAdapter(
    typeToAdapterMap: SparseArray<IDelegateAdapter<*, *>>
) : CompositeDelegateAdapter<IAdapterItem>(typeToAdapterMap) {

    class Builder {

        private var count: Int = 0
        private val typeToAdapterMap: SparseArray<IDelegateAdapter<*, *>> = SparseArray()

        fun add(delegateAdapter: IDelegateAdapter<*, out IAdapterItem>): Builder {
            typeToAdapterMap.put(count++, delegateAdapter)
            return this
        }

        fun build(): CompositeAdapter {
            require(count != 0) { "Register at least one adapter" }
            return CompositeAdapter(typeToAdapterMap)
        }
    }
}