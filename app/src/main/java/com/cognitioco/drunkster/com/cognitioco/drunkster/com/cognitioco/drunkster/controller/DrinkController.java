package com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Drink;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.DrinkDAO;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.DrinkDAOSkeleton;

import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */

public class DrinkController implements DrinkDAOSkeleton {

    private DrinkDAO dao;

    public DrinkController() {
        dao = new DrinkDAO();
    }

    @Override
    public void createDrink(Drink drink) {
        dao.createDrink(drink);
    }

    @Override
    public void UpdateDrink(Drink drink) {
        dao.createDrink(drink);
    }

    @Override
    public void deleteDrink(Drink drink) {
        dao.deleteDrink(drink);
    }

    @Override
    public Drink retrieveDrinkById(Drink drink) {
        return dao.retrieveDrinkById(drink);
    }

    @Override
    public Drink retrieveDrinkByName(Drink drink) {
        return dao.retrieveDrinkByName(drink);
    }

    @Override
    public List<Drink> retireveAllDrinks() {
        return dao.retireveAllDrinks();
    }
}
