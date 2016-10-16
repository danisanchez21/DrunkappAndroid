package com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Feeling;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.FeelingDAO;

import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */

public class FeelingsController {

    private FeelingDAO dao;

    public FeelingsController() {
        dao = new FeelingDAO();
    }

    public List<Feeling> retrieveAllFeelings() {
        return dao.retreieveAlleelings();
    }

    public void createFeeling(Feeling feeling) {
        dao.createFeeling(feeling);
    }

    public Feeling retrieveFeelingById(Feeling feeling) {
        return dao.retrieveFeelingById(feeling);
    }
}
