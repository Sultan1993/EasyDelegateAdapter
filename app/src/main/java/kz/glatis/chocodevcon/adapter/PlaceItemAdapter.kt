package kz.glatis.chocodevcon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.glatis.chocodevcon.R
import kz.glatis.chocodevcon.model.PlaceAdapterModel

class PlaceItemAdapter internal constructor(private val subItemList: List<PlaceAdapterModel>) :
    RecyclerView.Adapter<PlaceItemAdapter.PlaceItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PlaceItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_place, viewGroup, false)
        return PlaceItemViewHolder(view)
    }

    override fun onBindViewHolder(placeItemViewHolder: PlaceItemViewHolder, i: Int) {
        val placeItem: PlaceAdapterModel = subItemList[i]
        placeItemViewHolder.tvSubItemTitle.text = placeItem.placeName
        Glide.with(placeItemViewHolder.itemView.rootView)
            .load(placeItem.placeImg)
            .into(placeItemViewHolder.placeImageView)
    }

    override fun getItemCount(): Int {
        return subItemList.size
    }

    inner class PlaceItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSubItemTitle: TextView = itemView.findViewById(R.id.titleTextView)
        var placeImageView: ImageView = itemView.findViewById(R.id.placeImageView)
    }
}
