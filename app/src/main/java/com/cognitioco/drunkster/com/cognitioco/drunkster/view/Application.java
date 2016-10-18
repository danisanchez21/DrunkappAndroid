package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.SharedPreferences;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Drink;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Feeling;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.User;
import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by dasan on 10/16/2016.
 */

public class Application extends SugarApp {


    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
        Feeling.findById(Feeling.class, 0);

        SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);

        if (!pref.getBoolean("first_use", false)) {
            Feeling feel1 = new Feeling("Sleepy", R.mipmap.ic_sleeping);
            Feeling feel2 = new Feeling("Hungry", R.mipmap.ic_hungry);
            Feeling feel3 = new Feeling("Drunk", R.mipmap.ic_drunkhappy);
            Feeling feel4 = new Feeling("Healthy", R.mipmap.ic_healthy);

            feel1.save();
            feel2.save();
            feel3.save();
            feel4.save();

            Drink drink = new Drink();
            drink.setVolume(12);
            drink.setName("12 Oz");
            drink.setDrinkProof(50);
            drink.setAsset(R.mipmap.ic_beerpint);
            drink.save();

            Drink drink1 = new Drink();
            drink1.setVolume(18);
            drink1.setName("18 Oz");
            drink1.setDrinkProof(50);
            drink1.setAsset(R.mipmap.ic_vodka);
            drink1.save();

            Drink drink2 = new Drink();
            drink2.setVolume(8);
            drink2.setName("8 Oz");
            drink2.setDrinkProof(50);
            drink2.setAsset(R.mipmap.ic_cocktail);
            drink2.save();

            Drink drink3 = new Drink();
            drink3.setVolume(10);
            drink3.setName("10 Oz");
            drink3.setDrinkProof(50);
            drink3.setAsset(R.mipmap.ic_beerglass);
            drink3.save();

            Drink drink4 = new Drink();
            drink4.setVolume(5);
            drink4.setName("5 Oz");
            drink4.setDrinkProof(50);
            drink4.setAsset(R.mipmap.ic_wine);
            drink4.save();
            pref.edit().putBoolean("first_use", true).commit();

            User user = new User();

            user.setName("User");
            user.setSex(User.Sex.MALE);
            user.setWeight(120);
            user.save();
        }




    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
