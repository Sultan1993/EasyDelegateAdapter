package kz.glatis.chocodevcon

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem
import kz.glatis.chocodevcon.model.AuthAdapterModel
import kz.glatis.chocodevcon.model.BookingAdapterModel
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

        _listItems.value = listOf<DelegateAdapterItem>(
            authItem,
            bookingItem,
            totalSumItem,
            bookingItem,
            authItem,
            totalSumItem,
            totalSumItem,
            totalSumItem
        )
    }
}