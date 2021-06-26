package kz.glatis.chocodevcon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem
import kz.glatis.chocodevcon.model.AuthAdapterModel
import kz.glatis.chocodevcon.model.BookingAdapterModel
import kz.glatis.chocodevcon.model.PlaceAdapterModel
import kz.glatis.chocodevcon.model.TotalSumAdapterModel

class MainViewModel : ViewModel() {

    private val _listItems = MutableLiveData<List<DelegateAdapterItem>>()
    val listItems : LiveData<List<DelegateAdapterItem>>
        get() = _listItems

    init {
        setupList()
    }

    private fun setupList() {
        val authItem = AuthAdapterModel("+7 701 123 45 67")
        val bookingItem = BookingAdapterModel(
            "Almaty",
            "Astana",
            "05:33",
            "12:56"
        )
        val totalSumItem = TotalSumAdapterModel(25000, 1200)

        val placeItem = listOf(
            PlaceAdapterModel("Hawaii", ""),
            PlaceAdapterModel("Spain", ""),
            PlaceAdapterModel("Japan", ""),
            PlaceAdapterModel("Australia", ""),
            PlaceAdapterModel("Venezuela", ""),
            PlaceAdapterModel("Colombia", ""),
            PlaceAdapterModel("Netherlands", ""),
            PlaceAdapterModel("Germany", ""))

        placeItem.forEachIndexed { index, _ ->
            _listItems.value = listOf(
                authItem,
                bookingItem,
                totalSumItem,
                bookingItem,
                authItem,
                totalSumItem,
                totalSumItem,
                placeItem[index]
            )
        }
    }
}
