package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller.RegistryController;


public class BaseClass extends AppCompatActivity implements
        ProgressBarFragment.OnMainFragmentInteractionListener, AddDrinkFragment.OnAddDrinkFragment, RegisterFragment.OnRegisterFragmentInteractionListener,
        UserSettings.OnUserFragmentInteractionListener, GameFragment.OnGameFragmentInteractionListener, Chart.OnFragmentChart, ContactsDisplaySettings.OnContactSettingsFragmentInteractionListener {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    AddDrinkFragment addDrink;
    RegisterFragment registerFragment;
    SharedPreferences prefs;
    ProgressBarFragment progressFragment;
    UserSettings userFragment;
    GameFragment gameFragment;
    ContactsDisplaySettings contactSettingsFragment;

    RegistryController regController;

    double currentBAC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ////////////////////////////////////////////////////////////////////////////////////////////
        /// Setting contentview
        ///
        ////////////////////////////////////////////////////////////////////////////////////////////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        //SugarContext.init(getApplicationContext());

        regController = new RegistryController();


        ////////////////////////////////////////////////////////////////////////////////////////////
        // Check is it is the first run of the application annd if it is run database code and show t
        // tutorial
        //
        ////////////////////////////////////////////////////////////////////////////////////////////
        prefs = getSharedPreferences("com.cognitioco.drunkster", MODE_PRIVATE);
        prefs.edit().putBoolean("firstRun", true).commit();

        if (prefs.getBoolean("firstRun", true)) {

        } else {
            //Do something
            prefs.edit().putBoolean("firstRun", false).commit();


        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        /// Inititalization
        ///
        ////////////////////////////////////////////////////////////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        setNavigationDrawerComponents((NavigationView) findViewById(R.id.mainNavigationView));

        if (findViewById(R.id.fragmentFrame) != null) {

            progressFragment = new ProgressBarFragment();


            getSupportFragmentManager().beginTransaction().add(R.id.fragmentFrame, progressFragment).commit();
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

    private void setNavigationDrawerComponents(NavigationView view) {
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.addDrink) {
                    onAddDrinkPressed();
                    item.setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.registryButtonMenu) {

                    if (registerFragment == null) {
                        //Chart testchart = new Chart();

                        
                        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, testchart, "registerFragment").addToBackStack(null).commit();
						getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, registerFragment, "registerFragment").addToBackStack(null).commit();
                    } else {
                        //getSupportFragmentManager().beginTransaction().replace(R.id.chartfragment, registerFragment, "registerFragment").addToBackStack(null).commit();
						getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, registerFragment, "registerFragment").addToBackStack(null).commit();
                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.settingsButton) {

                    if (userFragment == null) {
                        userFragment = new UserSettings();

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, userFragment, "UserFragment").addToBackStack(null).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, userFragment, "UserFragment").addToBackStack(null).commit();
                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.navMenuReflexGame) {


                    gameFragment = new GameFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, gameFragment, null).addToBackStack(null).commit();


                    drawerLayout.closeDrawer(GravityCompat.START);

                }
                else if (id == R.id.btn_contactsOpen)
                {
                    contactSettingsFragment = new ContactsDisplaySettings();
                    if (contactSettingsFragment == null)
                    {
                        contactSettingsFragment = new ContactsDisplaySettings();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, contactSettingsFragment, "ContactSettingsFragment").addToBackStack(null).commit();

                    }
                    else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, contactSettingsFragment, "ContactSettingsFragment").addToBackStack(null).commit();
                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
    }

    @Override
    public void onAddDrinkPressed() {

        if (addDrink == null) {
            addDrink = new AddDrinkFragment();
            addDrink.setDrinkAddedListener(progressFragment);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, addDrink, "DrinkFragment").addToBackStack(null).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, addDrink, "DrinkFragment").addToBackStack(null).commit();
        }

    }


    @Override
    public void OnAddDrinkInteraction() {
        //do nothing
    }


    @Override
    public void onRegisterFragmentInteraction(Uri uri) {
        //do Nothing
    }


    @Override
    public void onUserFragmentInteraction(Uri uri) {
        //do Nothing for now
    }

    @Override
    public void onGameFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentChart(Uri uri) {

    }
}
