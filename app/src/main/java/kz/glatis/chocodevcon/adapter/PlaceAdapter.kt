package kz.glatis.chocodevcon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.glatis.chocodevcon.R
import kz.glatis.chocodevcon.databinding.ItemPlaceSectionBinding
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapter
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem
import kz.glatis.chocodevcon.model.PlaceAdapterModel

class PlaceAdapter(
    private val placeItems: List<PlaceAdapterModel>
) : DelegateAdapter<PlaceAdapterModel, PlaceAdapter.PlaceViewHolder>(PlaceAdapterModel::class.java) {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        PlaceViewHolder(
            DataBindingUtil.inflate(LayoutInflater
            .from(parent.context), R.layout.item_place_section, parent, false))

    override fun bindViewHolder(
        model: PlaceAdapterModel,
        viewHolder: PlaceViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class PlaceViewHolder(
        private val binding: ItemPlaceSectionBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PlaceAdapterModel) {
            //binding.titleTextView.text = item.placeName

            // Create layout manager with initial prefetch item count

            // Create layout manager with initial prefetch item count
            val layoutManager = LinearLayoutManager(
                binding.placeRecycler.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            layoutManager.initialPrefetchItemCount = placeItems.size

            // Create sub item view adapter

            // Create sub item view adapter
            val subItemAdapter = PlaceItemAdapter(placeItems)

            binding.placeRecycler.layoutManager = layoutManager
            binding.placeRecycler.adapter = subItemAdapter
            binding.placeRecycler.setRecycledViewPool(viewPool)
        }
    }
}