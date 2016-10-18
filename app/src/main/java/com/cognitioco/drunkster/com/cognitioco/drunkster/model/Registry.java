package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dasan on 10/12/2016.
 */

public class Registry extends SugarRecord {

    private Drink drink;
    private double currentBAC;
    private String timeTakenDB;


    @Ignore
    private Calendar timeTaken;
    private int numOfDrinks;
    private Feeling feeling;

    public Registry(){}

    public Registry(long id, Drink drink, double currentBAC, Calendar timeTaken, int numOfDrinks) {
        setId(id);
        this.drink = drink;
        this.currentBAC = currentBAC;

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyyy-mm-dd hh:mm:ss");
        this.timeTakenDB = format.format(timeTaken);
        this.timeTaken = timeTaken;
        this.numOfDrinks = numOfDrinks;
    }

    public Registry(Drink drink, double currentBAC, Calendar timeTaken, int numOfDrinks) {
        this.drink = drink;
        this.currentBAC = currentBAC;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-mm-dd hh:mm:ss");
        this.timeTakenDB = format.format(timeTaken);
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

    public String getTimeTakenDB() {


        return timeTakenDB;
    }

    public void setTimeTakenDB(String timeTaken) {

        timeTakenDB = timeTaken;
    }

    public Date getTimeTaken() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {
            return format.parse(timeTakenDB);
        } catch (Exception e) {
            return null;
        }

    }

    public void setTimeTaken(Calendar timeTaken) {

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-mm-dd hh:mm:ss");
        this.timeTakenDB = format.format(timeTaken.getTime());
        this.timeTaken = timeTaken;
    }

    public int getNumOfDrinks() {
        return numOfDrinks;
    }

    public void setNumOfDrinks(int numOfDrinks) {
        this.numOfDrinks = numOfDrinks;
    }

    public Feeling getFeeling() {
        return feeling;
    }

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
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
