package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Feeling;

import java.util.Collections;
import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */
public class FeelingRecyclerViewAdapter extends RecyclerView.Adapter<FeelingRecyclerViewAdapter.ViewHolderFeelings> implements OnItemClickListener {

    List<Feeling> list = Collections.emptyList();
    Context context;
    ViewHolderFeelings holdr;
    int positionDrink;
    ItemChanged listener;
    View lastChecked;

    public FeelingRecyclerViewAdapter(List<Feeling> list, Context context) {
        this.list = list;
        this.context = context;

    }


    @Override
    public ViewHolderFeelings onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
        ViewHolderFeelings holder = new ViewHolderFeelings(view);
        holder.setListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderFeelings holder, int position) {


        holder.subtitile.setText(list.get(position).getName());
        holder.imageButton.setImageResource(list.get(position).getResourceId());


    }

    public void setItemChangedListener(ItemChanged itemChanged) {
        this.listener = itemChanged;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public int getPosition() {
        return positionDrink;
    }

    @Override
    public void onItemClick(int position) {

        this.positionDrink = position;
        listener.ItemChanged(position);
    }


    public class ViewHolderFeelings extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView subtitile;
        ImageButton imageButton;
        OnItemClickListener listener;
        View itemView;
        int position;

        public ViewHolderFeelings(View itemView) {
            super(itemView);

            this.itemView = itemView;
            itemView.setClickable(true);
            subtitile = (TextView) itemView.findViewById(R.id.imageListViewSubtitle);
            imageButton = (ImageButton) itemView.findViewById(R.id.imageListViewButton);
            itemView.setOnClickListener(this);
            imageButton.setOnClickListener(this);
        }

        public void setListener(OnItemClickListener listener) {
            this.listener = listener;

        }

        @Override
        public void onClick(View v) {

            position = getLayoutPosition();
            listener.onItemClick(position);


            if (lastChecked != null) {
                lastChecked.setSelected(false);
            }

            itemView.setSelected(!itemView.isSelected());
            lastChecked = itemView;

            //itemView.setSelected(true);

        }
    }




}
