package kz.glatis.chocodevcon

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.glatis.chocodevcon.databinding.ItemAuthBinding
import kz.glatis.chocodevcon.databinding.ItemBookingBinding
import kz.glatis.chocodevcon.databinding.ItemTotalSumBinding

class ItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<ListItem>().apply {
        add(ListItem.AuthItem())
        add(ListItem.TotalSumItem())
        add(ListItem.BookingItem())
    }

    sealed class ListItem {

        companion object {
            const val AUTH_ITEM = 0
            const val TOTAL_SUM_ITEM = 1
            const val BOOKING_ITEM = 2
        }

        abstract val itemViewType: Int

        data class AuthItem(override val itemViewType: Int = AUTH_ITEM) : ListItem()
        data class TotalSumItem(override val itemViewType: Int = TOTAL_SUM_ITEM) : ListItem()
        data class BookingItem(override val itemViewType: Int = BOOKING_ITEM) : ListItem()
    }

    fun createListItems(items: List<Any>) {
        //create your list here
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int = items[position].itemViewType

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ListItem.AUTH_ITEM -> {
                AuthViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                    R.layout.item_auth, parent, false))
            }

            ListItem.TOTAL_SUM_ITEM -> {
                TotalSumViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                    R.layout.item_total_sum, parent, false))
            }

            ListItem.BOOKING_ITEM -> {
                BookingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                    R.layout.item_booking, parent, false))
            }

            else -> {
                throw IllegalStateException("Item not supported")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            ListItem.AUTH_ITEM -> (holder as AuthViewHolder).bind()
            ListItem.TOTAL_SUM_ITEM -> (holder as TotalSumViewHolder).bind()
            ListItem.BOOKING_ITEM -> (holder as BookingViewHolder).bind()
        }
    }

    inner class AuthViewHolder(private val binding: ItemAuthBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }

    inner class TotalSumViewHolder(private val binding: ItemTotalSumBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }

    inner class BookingViewHolder(private val binding: ItemBookingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }
}