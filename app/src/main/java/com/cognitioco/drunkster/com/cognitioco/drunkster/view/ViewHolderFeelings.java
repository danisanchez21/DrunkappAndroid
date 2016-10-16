package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cognitioco.drunkster.R;

/**
 * Created by dasan on 10/15/2016.
 */

public class ViewHolderFeelings extends ViewHolder {

    TextView subtitile;
    ImageButton imageButton;

    public ViewHolderFeelings(View itemView) {
        super(itemView);

        subtitile = (TextView) itemView.findViewById(R.id.imageListViewSubtitle);
        imageButton = (ImageButton) itemView.findViewById(R.id.imageListViewButton);

    }
}
