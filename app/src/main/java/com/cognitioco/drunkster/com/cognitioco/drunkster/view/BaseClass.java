package com.cognitioco.drunkster.com.cognitioco.drunkster.view;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Drink;


public class BaseClass extends AppCompatActivity implements
ProgressBarFragment.OnMainFragmentInteractionListener , AddDrinkFragment.OnAddDrinkFragment{

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    AddDrinkFragment addDrink;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ////////////////////////////////////////////////////////////////////////////////////////////
        /// Setting contentview
        ///
        ////////////////////////////////////////////////////////////////////////////////////////////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);


        ////////////////////////////////////////////////////////////////////////////////////////////
        // Check is it is the first run of the application annd if it is run database code and show t
        // tutorial
        //
        ////////////////////////////////////////////////////////////////////////////////////////////
        prefs = getSharedPreferences("com.cognitioco.drunkster", MODE_PRIVATE);

        if(prefs.getBoolean("firstRun",true)){

        }else{
            //Do something
            prefs.edit().putBoolean("firstRun",false).commit();

            Drink dr = new Drink();
            dr.setDrinkProof(10);
            dr.setName("Test Drink");
            dr.setVolume(12);
            dr.save();
        }
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

        setNavigationDrawerComponents((NavigationView) findViewById(R.id.mainNavigationView));

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


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //do nothing for now
    }

    private void setNavigationDrawerComponents(NavigationView view){
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id  = item.getItemId();
                if(id == R.id.addDrink){
                    onAddDrinkPressed();
                    item.setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
    }

    @Override
    public void onAddDrinkPressed() {

        //if(addDrink == null) {
            addDrink = new AddDrinkFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, addDrink).addToBackStack(null).commit();
       // }

    }


    @Override
    public void OnAddDrinkInteraction(Uri uri) {

    }
}
