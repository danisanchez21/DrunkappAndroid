package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Drink;

import java.util.Collections;
import java.util.List;

/**
 * Created by dasan on 10/17/2016.
 */

public class DrinkRecyclerViewAdapter extends RecyclerView.Adapter<DrinkRecyclerViewAdapter.DrinkViewHolder> {


    List<Drink> list = Collections.emptyList();
    Context context;
    View lastChecked;
    int itemPosition;

    public DrinkRecyclerViewAdapter(List<Drink> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DrinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
        DrinkViewHolder holder = new DrinkViewHolder(view);

        return holder;

        //return null;
    }

    @Override
    public void onBindViewHolder(DrinkViewHolder holder, int position) {
        holder.subtitle.setText(list.get(position).getName());
        holder.imageButton.setImageResource(list.get(position).getAsset());
    }

    public int getPosition() {
        return itemPosition;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        View itemView;
        TextView subtitle;
        ImageButton imageButton;


        public DrinkViewHolder(View itemView) {
            super(itemView);


            this.itemView = itemView;
            itemView.setClickable(true);
            subtitle = (TextView) itemView.findViewById(R.id.imageListViewSubtitle);
            imageButton = (ImageButton) itemView.findViewById(R.id.imageListViewButton);
            itemView.setOnClickListener(this);
            imageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemPosition = getLayoutPosition();
            //listener.onItemClick(position);


            if (lastChecked != null) {
                lastChecked.setSelected(false);
            }

            itemView.setSelected(!itemView.isSelected());
            lastChecked = itemView;
        }
    }
}
