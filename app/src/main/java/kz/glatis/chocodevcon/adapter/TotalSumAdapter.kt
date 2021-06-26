package kz.glatis.chocodevcon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapter
import kz.glatis.chocodevcon.R
import kz.glatis.chocodevcon.databinding.ItemTotalSumBinding
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem
import kz.glatis.chocodevcon.model.TotalSumAdapterModel

class TotalSumAdapter:
    DelegateAdapter<TotalSumAdapterModel, TotalSumAdapter.TotalSumViewHolder>(TotalSumAdapterModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        TotalSumViewHolder(
            DataBindingUtil.inflate(LayoutInflater
            .from(parent.context), R.layout.item_total_sum, parent, false))

    override fun bindViewHolder(
        model: TotalSumAdapterModel,
        viewHolder: TotalSumViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class TotalSumViewHolder(
        private val binding: ItemTotalSumBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TotalSumAdapterModel) {
            binding.ticketPriceLabel.text = item.ticketPrice.toString()
            binding.insurancePriceLabel.text = item.insurancePrice.toString()
            binding.totalSumLabel.text = item.totalPrice.toString()
        }
    }
}