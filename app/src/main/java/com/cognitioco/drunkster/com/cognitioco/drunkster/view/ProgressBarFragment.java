package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cognitioco.drunkster.R;


public class ProgressBarFragment extends Fragment {



    private OnMainFragmentInteractionListener mListener;

    public ProgressBarFragment() {
        // Required empty public constructor
    }

    @TargetApi(24)
    @Override
    public void setArguments(Bundle args) {
        ProgressBar pb = (ProgressBar) getView().findViewById(R.id.circle_progress_bar);
        pb.setProgress(20,true);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_progress_bar, container, false);
        FloatingActionButton myFab = (FloatingActionButton) v.findViewById(R.id.addDrinkButton);
        myFab.setOnClickListener(clickReact);
        // Inflate the layout for this fragment
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event

    public View.OnClickListener clickReact = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onAddDrinkPressed();
        }
    };

    public void onAddDrinkPressed() {
        if (mListener != null) {
            mListener.onAddDrinkPressed();
        }
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMainFragmentInteractionListener) {
            mListener = (OnMainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnMainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void onAddDrinkPressed();
    }
}
