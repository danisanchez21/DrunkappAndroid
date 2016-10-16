package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Feeling;

import java.util.Collections;
import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */

public class FeelingRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderFeelings> {

    List<Feeling> list = Collections.emptyList();
    Context context;

    public FeelingRecyclerViewAdapter(List<Feeling> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public ViewHolderFeelings onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false);
        ViewHolderFeelings holder = new ViewHolderFeelings(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderFeelings holder, int position) {

        holder.subtitile.setText(list.get(position).getName());
        holder.imageButton.setImageResource(list.get(position).getResourceId());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
