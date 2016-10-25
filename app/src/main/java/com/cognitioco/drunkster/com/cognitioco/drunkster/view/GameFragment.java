package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognitioco.drunkster.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameFragment.OnGameFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment implements GameListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int score;
    private int rounds;
    private int misses;

    private int width;
    private int height;

    private TextView textScore;
    private TextView textMisses;

    private GameView gameView;

    private CountDownTimer timer;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Vibrator vib;
    private AlertDialog.Builder dialog;

    private OnGameFragmentInteractionListener mListener;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ExecuteGame();
        }
    };

    public GameFragment() {


    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
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
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        textScore = (TextView) v.findViewById(R.id.scorelabel);
        textMisses = (TextView) v.findViewById(R.id.missesLabel);
        v.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        gameView = (GameView) v.findViewById(R.id.gameViewInside);
        gameView.setSelectionListener(this);

        vib = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                gameView.invalidate();
            }

            @Override
            public void onFinish() {
                vib.vibrate(100);
                getFragmentManager().popBackStack();
                if (score <= 0) {

                } else {

                }


            }
        }.start();

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onGameFragmentInteraction(uri);
        }
    }

    public void ExecuteGame() {


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGameFragmentInteractionListener) {
            mListener = (OnGameFragmentInteractionListener) context;
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
    public void onUserSelection(boolean correct) {
        if (correct) {
            score += 1;
            if (score > 3) {
                score = 0;
            } else {
                textScore.setText(String.valueOf(score));
            }

        } else {
            misses += 1;
            textMisses.setText(String.valueOf(misses));
            vib.vibrate(50);
        }
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
    public interface OnGameFragmentInteractionListener {
        // TODO: Update argument type and name
        void onGameFragmentInteraction(Uri uri);
    }

    public class position {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
