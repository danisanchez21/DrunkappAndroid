package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.RegistryController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Registry;

import java.util.List;
import java.util.Locale;


public class ProgressBarFragment extends Fragment implements DrinkAddedListener {

    RegistryController regcontroller;
    double currentBAC = 0.0;
    boolean firstDisplay = true;

    private OnMainFragmentInteractionListener mListener;
    public View.OnClickListener clickReact = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onAddDrinkPressed();
        }
    };
    private FragmentManager.OnBackStackChangedListener backStackListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {


        }
    };


    public ProgressBarFragment() {
        // Required empty public constructor
        regcontroller = new RegistryController();
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
    // Inflate the layout for this fragment


    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_progress_bar, container, false);
        FloatingActionButton addDrinkFAB = (FloatingActionButton) v.findViewById(R.id.addDrinkButton);
        addDrinkFAB.setOnClickListener(clickReact);

        ProgressBar pb = (ProgressBar) v.findViewById(R.id.circle_progress_bar);
        List<Registry> list = regcontroller.retrieveAllRegistries();

        TextView tv = (TextView) v.findViewById(R.id.BACpercent);

        double bac = 0;
        for (int i = 0; i < list.size(); i++) {
            bac += list.get(i).getCurrentBAC();
        }

        String string = String.format(Locale.US, "%1$,.3f", bac);
        tv.setText(string);

        ProgrssBarUpdate update = new ProgrssBarUpdate();
        update.setProgressBar(pb, bac);

        Thread th = new Thread(update);

        th.start();


        return v;
    }

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

    @Override
    public void OnAddDrinkInteraction() {
        List<Registry> registry = regcontroller.retrieveAllRegistries();
        if (registry != null && registry.size() > 0) {
            Registry lastReg = registry.get(registry.size() - 1);

            ProgressBar pb = (ProgressBar) getView().findViewById(R.id.circle_progress_bar);

            double newBac = lastReg.getCurrentBAC();
            currentBAC = currentBAC + newBac;
            pb.setProgress(getPercentage(currentBAC));

            TextView tv = (TextView) getView().findViewById(R.id.BACpercent);
            String number = String.format(Locale.US, "%1$,.2f", currentBAC);
        }
    }

    private int getPercentage(double number) {
        double percentage = (0.08 - number) * 100;

        return (int) percentage;
    }
    public interface OnMainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void onAddDrinkPressed();
    }

    public class ProgrssBarUpdate implements Runnable {


        double bac = 0;
        private ProgressBar prob;

        public void setProgressBar(ProgressBar progb, double bac) {
            prob = progb;
            this.bac = bac;
        }

        @Override
        public void run() {


            if (bac > 0.08) {
                prob.setProgress(100);


            } else {
                prob.setProgress((getPercentage(bac)));

            }
        }

        private int getPercentage(double number) {
            double percentage = 0;
            int comparison = Double.compare(number, 0.0);
            if (comparison <= 0) {
            } else {

                // percentage = (0.080000000 - number) * 100;

                percentage = (number * 100) / 0.08;
            }

            return (int) percentage;
        }
    }
}
