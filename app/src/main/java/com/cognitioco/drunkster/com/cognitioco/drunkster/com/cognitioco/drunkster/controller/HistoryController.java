package com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.History;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.HistoryDAO;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.HistoryDAOInterface;

import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */

public class HistoryController implements HistoryDAOInterface {


    HistoryDAO dao;

    public HistoryController() {
        dao = new HistoryDAO();
    }

    @Override
    public void createHistory(History hist) {

    }

    @Override
    public void updateHistory(History hist) {

    }

    @Override
    public void deleteHistory(History hist) {

    }

    @Override
    public void deleteAllHistory() {

    }

    @Override
    public List<History> retrieveAllHistory() {
        return null;
    }

    @Override
    public History retrieveById(History hist) {
        return null;
    }
}
