package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cognitioco.drunkster.R;

public class GameActivity extends AppCompatActivity {

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ExecuteGame();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activity_game


        setContentView(R.layout.activity_game);



    }

    public void ExecuteGame() {

    }


}
