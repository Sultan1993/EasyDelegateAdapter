package kz.glatis.chocodevcon.model

import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem

data class PlaceAdapterModel(
    val placeName: String = "Venezuela",
    val placeImg: String = ""
) : DelegateAdapterItem {

    val subItemList: MutableList<PlaceAdapterModel> = mutableListOf()

    override fun id(): Any = PlaceAdapterModel::class.toString()

    override fun content(): Any = PlaceAdapterModel(placeName, placeImg)
}