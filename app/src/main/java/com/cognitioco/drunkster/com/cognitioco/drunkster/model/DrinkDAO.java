package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;

/**
 * Created by dasan on 10/12/2016.
 */

public class DrinkDAO implements DrinkDAOSkeleton{

    @Override
    public void createDrink(Drink drink) {
        drink.save();
    }

    @Override
    public void UpdateDrink(Drink drink) {

    }

    @Override
    public void deleteDrink(Drink drink) {
        drink.delete();
    }

    @Override
    public Drink retrieveDrinkById(Drink drink) {
        return drink.findById(Drink.class,drink.getId());
    }


    @Override
    public List<Drink> retrieveDrinkByName(Drink drink) {

        return  drink.find(Drink.class,"where name=?",drink.getName());
    }

    @Override
    public List<Drink> retireveAllDrinks(Drink drink) {
        return drink.find(Drink.class,"","");
    }
}
