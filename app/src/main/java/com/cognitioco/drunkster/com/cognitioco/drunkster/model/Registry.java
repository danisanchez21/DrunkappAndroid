package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by dasan on 10/12/2016.
 */

public class Registry extends SugarRecord {

    private Drink drink;
    private double currentBAC;
    private Date timeTaken;
    private int numOfDrinks;

    public Registry(){}

    public Registry(long id, Drink drink, double currentBAC, Date timeTaken, int numOfDrinks) {
        setId(id);
        this.drink = drink;
        this.currentBAC = currentBAC;
        this.timeTaken = timeTaken;
        this.numOfDrinks = numOfDrinks;
    }

    public Registry(Drink drink, double currentBAC, Date timeTaken, int numOfDrinks) {
        this.drink = drink;
        this.currentBAC = currentBAC;
        this.timeTaken = timeTaken;
        this.numOfDrinks = numOfDrinks;
    }

    public Registry(long id) {
        setId(id);
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public double getCurrentBAC() {
        return currentBAC;
    }

    public void setCurrentBAC(double currentBAC) {
        this.currentBAC = currentBAC;
    }

    public Date getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Date timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getNumOfDrinks() {
        return numOfDrinks;
    }

    public void setNumOfDrinks(int numOfDrinks) {
        this.numOfDrinks = numOfDrinks;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "id=" + getId() +
                ", drink=" + drink +
                ", currentBAC=" + currentBAC +
                ", timeTaken=" + timeTaken +
                ", numOfDrinks=" + numOfDrinks +
                '}';
    }
}
