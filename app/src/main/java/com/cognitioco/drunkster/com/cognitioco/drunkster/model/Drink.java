package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import com.orm.SugarRecord;

/**
 * Created by dasan on 10/12/2016.
 */

public class Drink extends SugarRecord
{
    private String name;
    private double Volume;
    private double DrinkProof;

    public Drink(){}

    public Drink( String name, double volume, double drinkProof) {
        this.name = name;
        Volume = volume;
        DrinkProof = drinkProof;
    }

    public Drink(long id) {
        super.setId(id);
    }

    public Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double volume) {
        Volume = volume;
    }

    public double getDrinkProof() {
        return DrinkProof;
    }

    public void setDrinkProof(double drinkProof) {
        DrinkProof = drinkProof;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", Volume=" + Volume +
                ", DrinkProof=" + DrinkProof +
                '}';
    }
}
