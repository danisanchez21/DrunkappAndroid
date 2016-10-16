package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;

/**
 * Created by dasan on 10/12/2016.
 */

public interface DrinkDAOSkeleton {


    void createDrink(Drink drink);
    void UpdateDrink(Drink drink);
    void deleteDrink(Drink drink);
    Drink retrieveDrinkById(Drink drink);

    Drink retrieveDrinkByName(Drink drink);

    List<Drink> retireveAllDrinks();

}
