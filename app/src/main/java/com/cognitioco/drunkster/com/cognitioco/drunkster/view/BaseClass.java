package com.cognitioco.drunkster.com.cognitioco.drunkster.view;
import android.view.View;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.cognitioco.drunkster.R;


public class BaseClass extends AppCompatActivity implements
ProgressBarFragment.OnMainFragmentInteractionListener , AddDrinkFragment.OnAddDrinkFragment{

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ////////////////////////////////////////////////////////////////////////////////////////////
        /// Setting contentview
        ///
        ////////////////////////////////////////////////////////////////////////////////////////////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        ////////////////////////////////////////////////////////////////////////////////////////////
        /// Inititalization
        ///
        ////////////////////////////////////////////////////////////////////////////////////////////
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        setSupportActionBar(toolbar);


        final ActionBar bar = getSupportActionBar();


        ////////////////////////////////////////////////////////////////////////////////////////////
        /// Setting supportBar properties
        ///
        ////////////////////////////////////////////////////////////////////////////////////////////
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setDisplayUseLogoEnabled(true);
        bar.setHomeAsUpIndicator(R.drawable.ic_drawer);
        bar.setHomeButtonEnabled(true);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        if(findViewById(R.id.fragmentFrame) != null){

            ProgressBarFragment mainFragment = new ProgressBarFragment();


            getSupportFragmentManager().beginTransaction().add(R.id.fragmentFrame,mainFragment).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //TextView textV = (TextView) findViewById(R.id.TextBox);

        switch (id) {

            case R.id.addDrink:
               // textV.setText("Adding Drink");
                break;
            case R.id.registryButtonMenu:
              //  textV.setText("Adding Drink");
                break;
            case R.id.historyButton:
               //textV.setText("Adding Drink");
                break;
            case R.id.settingsButton:
               // textV.setText("Adding Drink");
                break;
        }

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //do nothing for now
    }

    @Override
    public void onAddDrinkPressed() {
        AddDrinkFragment addDrink = new AddDrinkFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame,addDrink).addToBackStack(null).commit();

    }


    @Override
    public void OnAddDrinkInteraction(Uri uri) {

    }
}
