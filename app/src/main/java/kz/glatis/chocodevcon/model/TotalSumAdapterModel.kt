package kz.glatis.chocodevcon.model

import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem

data class TotalSumAdapterModel(
    val ticketPrice: Int,
    val insurancePrice: Int
) : DelegateAdapterItem {

    val totalPrice: Int
        get() = ticketPrice + insurancePrice

    override fun id(): Any = TotalSumAdapterModel::class.toString()

    override fun content(): Any = totalPrice
}