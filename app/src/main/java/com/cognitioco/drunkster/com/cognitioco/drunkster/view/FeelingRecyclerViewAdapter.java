package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Feeling;

import java.util.Collections;
import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */

public class FeelingRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderFeelings> {

    List<Feeling> list = Collections.emptyList();
    Context context;


    @Override
    public ViewHolderFeelings onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderFeelings holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
