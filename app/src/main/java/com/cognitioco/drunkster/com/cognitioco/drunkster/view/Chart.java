package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.RegistryController;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Registry;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Chart.OnFragmentChart} interface
 * to handle interaction events.
 * Use the {@link Chart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Chart extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RegistryController ChartController;

    private OnFragmentChart mListener;

    public Chart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Chart.
     */
    // TODO: Rename and change types and number of parameters
    public static Chart newInstance(String param1, String param2) {
        Chart fragment = new Chart();
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
        ChartController = new RegistryController();

        List<Registry> chartdata = ChartController.retrieveAllOrderbyDate();
        ArrayList<Entry> entries = new ArrayList<>();


        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        LineChart lineChart = (LineChart) view.findViewById(R.id.chart);

        //creating list of entries

        for(int i = 0; i < chartdata.size(); i++)
        {
            Registry reg = chartdata.get(i);
            SimpleDateFormat dateformat = new SimpleDateFormat("HH");
            String formatted = dateformat.format(reg.getTimeTaken());


            Entry dataentry = new Entry((float)reg.getCurrentBAC(),Integer.parseInt(formatted));

            entries.add(dataentry);
        }


        LineDataSet dataset = new LineDataSet(entries, "BAC level");

       //ArrayList<String> labels = new ArrayList();
//
       //for(int i = 0; i < chartdata.size(); i++)
       //{
       //    Registry reg = chartdata.get(i);
       //    SimpleDateFormat dateformat = new SimpleDateFormat("HH");
       //    String formatted = dateformat.format(reg.getTimeTaken());
//
       //    labels.add(formatted);
       //}

        ArrayList<String> labels = new ArrayList();
        labels.add("00:00");
        labels.add("1:00");
        labels.add("2:00");
        labels.add("3:00");
        labels.add("4:00");
        labels.add("5:00");
        labels.add("6:00");
        labels.add("7:00");
        labels.add("8:00");









        //Setting the data
        //LineData data = new LineData(new ArrayList<String>(), dataset);
        LineData data = new LineData(labels, dataset);
                lineChart.setData(data); // set the data and list of labels into chart
        lineChart.setDescription("RecentBAC");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
         return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentChart(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentChart) {
            mListener = (OnFragmentChart) context;
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
    public interface OnFragmentChart {
        // TODO: Update argument type and name
        void onFragmentChart(Uri uri);
    }
}
