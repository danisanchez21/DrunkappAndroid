package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.RegistryController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Drink;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Registry;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddDrinkFragment.OnAddDrinkFragment} interface
 * to handle interaction events.
 * Use the {@link AddDrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDrinkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RegistryController controller;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAddDrinkFragment mListener;
    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Registry reg = new Registry();
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onButtonPressed(null);
            Registry reg = new Registry();
            reg.setCurrentBAC(0.04);
            reg.setDrink(new Drink(0));
            reg.setNumOfDrinks(4);
            reg.setTimeTaken(new Date());

        }
    };

    public AddDrinkFragment() {
        // Required empty public constructor
        controller = new RegistryController();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddDrinkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddDrinkFragment newInstance(String param1, String param2) {
        AddDrinkFragment fragment = new AddDrinkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_add_drink, container, false);
        FloatingActionButton addFab = (FloatingActionButton) v.findViewById(R.id.acceptValues);
        addFab.setOnClickListener(onClickListener);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.OnAddDrinkInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAddDrinkFragment) {
            mListener = (OnAddDrinkFragment) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnAddDrinkFragment {
        // TODO: Update argument type and name
        void OnAddDrinkInteraction(Uri uri);
    }


}
