package kz.glatis.chocodevcon.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapter
import kz.glatis.chocodevcon.R
import kz.glatis.chocodevcon.databinding.ItemBookingBinding
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem
import kz.glatis.chocodevcon.model.BookingAdapterModel

class BookingAdapter:
        DelegateAdapter<BookingAdapterModel, BookingAdapter.BookingViewHolder>(BookingAdapterModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        BookingViewHolder(DataBindingUtil.inflate(LayoutInflater
            .from(parent.context), R.layout.item_booking, parent, false))

    override fun bindViewHolder(
        model: BookingAdapterModel,
        viewHolder: BookingViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class BookingViewHolder(
        private val binding: ItemBookingBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BookingAdapterModel) {
            binding.routeLabel.text = "${item.departureCity} - ${item.arrivalCity}"
            binding.routeLabel2.text = "${item.arrivalCity} - ${item.departureCity}"
        }
    }
}