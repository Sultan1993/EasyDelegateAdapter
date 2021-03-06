package kz.glatis.chocodevcon

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kz.glatis.chocodevcon.adapter.AuthAdapter
import kz.glatis.chocodevcon.adapter.BookingAdapter
import kz.glatis.chocodevcon.adapter.TotalSumAdapter
import kz.glatis.chocodevcon.delegateadapter.CompositeAdapter

/**
 * A simple [Fragment] subclass.
 */

class MainFragment : Fragment() {

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(TotalSumAdapter())
            .add(BookingAdapter())
            .add(AuthAdapter { })
            .build()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = compositeAdapter

        viewModel.listItems.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            compositeAdapter.submitList(it)
        })
    }
}