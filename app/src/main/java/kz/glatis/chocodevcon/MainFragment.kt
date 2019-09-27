package kz.glatis.chocodevcon


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kz.glatis.chocodevcon.core.diff.IAdapterItem

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private val items = ArrayList<ItemAdapter.ListItem>().apply {
        add(ItemAdapter.ListItem.AuthItem())
        add(ItemAdapter.ListItem.TotalSumItem())
        add(ItemAdapter.ListItem.BookingItem())
    }

    private val adapter = ItemAdapter()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.createListItems(items)
    }
}