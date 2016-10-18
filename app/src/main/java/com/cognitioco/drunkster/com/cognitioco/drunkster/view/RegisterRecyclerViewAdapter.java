package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Registry;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by dasan on 10/17/2016.
 */

public class RegisterRecyclerViewAdapter extends RecyclerView.Adapter<RegisterRecyclerViewAdapter.RegisterViewHolder> {

    List<Registry> list = Collections.emptyList();
    Context context;

    public RegisterRecyclerViewAdapter(List<Registry> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RegisterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.register_layout, parent, false);
        RegisterViewHolder holder = new RegisterViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RegisterViewHolder holder, int position) {
        holder.drinkSizeLabel.setText(list.get(position).getDrink().getName());
        holder.feelingLabel.setText("Feeling " + list.get(position).getFeeling().getName());

        String number = String.format(Locale.US, "%1$,.3f", list.get(position).getCurrentBAC());
        holder.bacLabel.setText("BAC: " + number);
        holder.timeLabel.setText("Time Taken: " + list.get(position).getTimeTakenDB());
        holder.imageView.setImageResource(list.get(position).getFeeling().getResourceId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //////////////////////
    //View Holder
    /////////////////////


    public class RegisterViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView feelingLabel;
        ImageView imageView;
        TextView bacLabel;
        TextView timeLabel;
        TextView drinkSizeLabel;

        public RegisterViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;
            feelingLabel = (TextView) itemView.findViewById(R.id.feelingRegisterLabel);
            imageView = (ImageView) itemView.findViewById(R.id.feelingImageRegister);
            bacLabel = (TextView) itemView.findViewById(R.id.BAClabel);
            timeLabel = (TextView) itemView.findViewById(R.id.TimeLabel);
            drinkSizeLabel = (TextView) itemView.findViewById(R.id.DrinkText);
        }
    }
}
