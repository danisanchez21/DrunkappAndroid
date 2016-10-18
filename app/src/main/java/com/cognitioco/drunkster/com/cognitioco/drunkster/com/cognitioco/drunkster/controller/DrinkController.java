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

    public static double calculateBAC(double _weight, int _sex, int _numberofdrinks, int _time, double proof, double volume) {

        double sexRate = 0;
        if (_sex == 1) {
            sexRate = 0.66;
        } else {
            sexRate = 0.73;
        }

        /*double ouncesConsumed = ((proof / 2) /100) * 5.14;
        double part1 = ouncesConsumed / (_weight * sexRate);
        double bac = part1 - (0.015 * _time);*/


        int alcoholdose = _numberofdrinks * 14; //14 is equivalent to the amount of alcohol in grams present in a standard drink.

        double WeightinGrams = _weight * 454; //454 is the amount of grams in 1lbs.

        double RawBAC = WeightinGrams * sexRate; //Weight in grams multiplied by the gender constant.

        double alcoholConsumed = alcoholdose / RawBAC;

        double BACpercentage = alcoholConsumed * 100;

        double CurrentBAC = BACpercentage - (_time * 0.015f);

        return CurrentBAC;
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
