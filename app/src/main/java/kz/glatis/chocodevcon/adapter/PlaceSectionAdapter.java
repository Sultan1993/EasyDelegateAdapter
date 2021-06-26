package kz.glatis.chocodevcon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kz.glatis.chocodevcon.R;
import kz.glatis.chocodevcon.model.PlaceAdapterModel;

public class PlaceSectionAdapter extends RecyclerView.Adapter<PlaceSectionAdapter.PlaceViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<PlaceAdapterModel> itemList;

    PlaceSectionAdapter(List<PlaceAdapterModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_place_section, viewGroup, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder itemViewHolder, int i) {
        PlaceAdapterModel item = itemList.get(i);
        itemViewHolder.tvItemTitle.setText(item.getPlaceName());

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                itemViewHolder.rvSubItem.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(item.getSubItemList().size());

        // Create sub item view adapter
        PlaceItemAdapter subItemAdapter = new PlaceItemAdapter(item.getSubItemList());

        itemViewHolder.rvSubItem.setLayoutManager(layoutManager);
        itemViewHolder.rvSubItem.setAdapter(subItemAdapter);
        itemViewHolder.rvSubItem.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemTitle;
        private RecyclerView rvSubItem;

        PlaceViewHolder(View itemView) {
            super(itemView);
            tvItemTitle = itemView.findViewById(R.id.titleTextView);
        }
    }
}