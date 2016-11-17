package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.DrinkController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.FeelingsController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.RegistryController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.UserController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Drink;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Registry;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.User;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddDrinkFragment.OnAddDrinkFragment} interface
 * to handle interaction events.
 * Use the {@link AddDrinkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDrinkFragment extends Fragment implements ItemChanged {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    DrinkController controller;
    FeelingsController feelingsController;
    UserController userController;
    DrinkAddedListener drinkAddedListener;

    LinearLayoutManager lny;

    boolean nowDate = false;
    Calendar timeTaken = Calendar.getInstance();

    Button selectime;

    int hour;
    int min;
    int numOfDrinks = 1;
    int feelingPosition;

    private DrinkRecyclerViewAdapter drinkadapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAddDrinkFragment mListener;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // onButtonPressed();

            Registry reg = new Registry();


            Drink drink = controller.retireveAllDrinks().get(drinkadapter.getPosition());

            User user = userController.retirveAll().get(0);

            reg.setCurrentBAC(DrinkController.calculateBAC(user.getWeight(), user.getSexDB(), numOfDrinks, drink.getDrinkProof(), drink.getVolume()));
            reg.setDrink(drink);
            reg.setNumOfDrinks(numOfDrinks);
            reg.setTimeTaken(timeTaken);
            reg.setFeeling(feelingsController.retrieveAllFeelings().get(feelingPosition));

            RegistryController regc = new RegistryController();
            regc.createRegistry(reg);
            getFragmentManager().popBackStack();





        }
    };
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            numOfDrinks = progress + 1;
            TextView tv = (TextView) getView().findViewById(R.id.quantity);
            String numof = String.format("%d", numOfDrinks);
            tv.setText(numof);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timeTaken.set(Calendar.HOUR, hourOfDay);
            timeTaken.set(Calendar.MINUTE, minute);
        }
    };
    private View.OnClickListener onPickTimeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FrameLayout frameLayout = (FrameLayout) v.findViewById(R.id.TimePickerLayout);

            Calendar cal = Calendar.getInstance();


            hour = cal.get(Calendar.HOUR_OF_DAY);
            min = cal.get(Calendar.MINUTE);

            TimePickerDialog tp = new TimePickerDialog(getContext(), timeSetListener, hour, min, true);
            tp.show();


        }
    };
    private OnCheckedChangeListener checkedListener = new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.isChecked()) {
                buttonView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                nowDate = false;
                selectime.setEnabled(true);
            } else {
                buttonView.setTextColor(ContextCompat.getColor(getContext(), R.color.bright_green));
                selectime.setEnabled(false);
                timeTaken = null;
                timeTaken = Calendar.getInstance();
            }
        }
    };

    public AddDrinkFragment() {
        // Required empty public constructor
        controller = new DrinkController();
        feelingsController = new FeelingsController();
        userController = new UserController();
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

    public void setDrinkAddedListener(DrinkAddedListener listener) {
        this.drinkAddedListener = listener;
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

        //RecyclerView
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.feelingsRecyclerView);
        FeelingRecyclerViewAdapter adapter = new FeelingRecyclerViewAdapter(feelingsController.retrieveAllFeelings(), getContext());
        recyclerView.setAdapter(adapter);
        lny = new LinearLayoutManager(getContext());
        lny.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(lny);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


        RecyclerView drinkrecycler = (RecyclerView) v.findViewById(R.id.drinkRecyclerViewRecyclerView);
        drinkadapter = new DrinkRecyclerViewAdapter(controller.retireveAllDrinks(), getContext());
        drinkrecycler.setAdapter(drinkadapter);
        LinearLayoutManager lnyd = new LinearLayoutManager(getContext());
        lnyd.setOrientation(LinearLayoutManager.HORIZONTAL);
        drinkrecycler.setLayoutManager(lnyd);
        //  snapHelper.attachToRecyclerView(drinkrecycler);


        adapter.setItemChangedListener(this);



        FloatingActionButton addFab = (FloatingActionButton) v.findViewById(R.id.acceptValues);
        addFab.setOnClickListener(onClickListener);

        selectime = (Button) v.findViewById(R.id.selectTimeButton);
        selectime.setOnClickListener(onPickTimeListener);

        SeekBar seekBar = (SeekBar) v.findViewById(R.id.howmanyseekbar);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        ToggleButton toggleButton = (ToggleButton) v.findViewById(R.id.justNowButton);
        toggleButton.setOnCheckedChangeListener(checkedListener);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.OnAddDrinkInteraction();
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

    public void onItemClick(int position) {

    }

    @Override
    public void ItemChanged(int position) {

        feelingPosition = position;
        int totalVisibleItems = lny.findLastVisibleItemPosition() - lny.findFirstVisibleItemPosition();
        int centeredItemPosition = totalVisibleItems / 2;
        lny.scrollToPosition(centeredItemPosition);

        // lny.scrollToPositionWithOffset(position,getView().getWidth() / 2);

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
        void OnAddDrinkInteraction();
    }


}
