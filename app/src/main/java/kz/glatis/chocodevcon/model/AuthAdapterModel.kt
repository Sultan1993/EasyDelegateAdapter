package kz.glatis.chocodevcon.model

import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem

data class AuthAdapterModel(
    val phone: String = "+7"
) : DelegateAdapterItem {

    override fun id(): Any = AuthAdapterModel::class.toString()

    override fun content(): Any = phone
}