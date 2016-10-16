package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;


public class FeelingDAO {


    public void createFeeling(Feeling feel) {
        feel.save();
    }

    public Feeling retrieveFeelingById(Feeling feeling) {
        return Feeling.findById(Feeling.class, feeling.getId());
    }

    public List<Feeling> retreieveAlleelings() {
        return Feeling.listAll(Feeling.class);
    }
}
