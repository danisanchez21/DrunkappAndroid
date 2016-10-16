package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import com.orm.SugarRecord;

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
        drink.save();
    }

    @Override
    public void deleteDrink(Drink drink) {
        drink.delete();
    }

    @Override
    public Drink retrieveDrinkById(Drink drink) {
        return SugarRecord.findById(Drink.class, drink.getId());
    }


    @Override
    public Drink retrieveDrinkByName(Drink drink) {

        return SugarRecord.find(Drink.class, "where name=?", drink.getName()).get(0);
    }

    @Override
    public List<Drink> retireveAllDrinks() {
        return Drink.listAll(Drink.class);
    }
}
