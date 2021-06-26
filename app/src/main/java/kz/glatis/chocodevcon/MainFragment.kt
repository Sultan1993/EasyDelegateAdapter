package kz.glatis.chocodevcon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kz.glatis.chocodevcon.adapter.AuthAdapter
import kz.glatis.chocodevcon.adapter.BookingAdapter
import kz.glatis.chocodevcon.adapter.PlaceAdapter
import kz.glatis.chocodevcon.adapter.TotalSumAdapter
import kz.glatis.chocodevcon.delegateadapter.CompositeAdapter
import kz.glatis.chocodevcon.model.PlaceAdapterModel

/**
 * A simple [Fragment] subclass.
 */

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val listPlaces = listOf(
        PlaceAdapterModel("Hawaii", "https://user-images.githubusercontent.com/4821464/123502729-1e3df900-d614-11eb-9dcb-7a1fcf1a13b2.png"),
        PlaceAdapterModel("Spain", "https://user-images.githubusercontent.com/4821464/123502727-1e3df900-d614-11eb-928d-c570788285b6.png"),
        PlaceAdapterModel("Japan", "https://user-images.githubusercontent.com/4821464/123502726-1da56280-d614-11eb-8a01-c55f20dfa928.png"),
        PlaceAdapterModel("Australia", "https://user-images.githubusercontent.com/4821464/123502725-1d0ccc00-d614-11eb-8385-3b73e4e5445c.png"),
        PlaceAdapterModel("Venezuela", "https://user-images.githubusercontent.com/4821464/123502724-1d0ccc00-d614-11eb-984c-22af9177de79.jpg"),
        PlaceAdapterModel("Colombia", "https://user-images.githubusercontent.com/4821464/123502723-1d0ccc00-d614-11eb-905e-0fbf5a1bda25.png"),
        PlaceAdapterModel("Netherlands", "https://user-images.githubusercontent.com/4821464/123502722-1c743580-d614-11eb-9bc5-2931f1e6c0b8.png"),
        PlaceAdapterModel("Germany", "https://user-images.githubusercontent.com/4821464/123502720-1bdb9f00-d614-11eb-95f0-04e96c407f64.png")
    )

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(TotalSumAdapter())
            .add(BookingAdapter())
            .add(AuthAdapter { })
            .add(PlaceAdapter(listPlaces))
            .build()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = requireActivity().findViewById(R.id.recyclerView)
        recyclerView.adapter = compositeAdapter

        viewModel.listItems.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            compositeAdapter.submitList(it)
        })
    }
}