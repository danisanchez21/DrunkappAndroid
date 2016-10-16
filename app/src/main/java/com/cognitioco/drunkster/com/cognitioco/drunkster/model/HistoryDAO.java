package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;


public class HistoryDAO implements HistoryDAOInterface {
    @Override
    public void createHistory(History hist) {
        hist.save();
    }

    @Override
    public void updateHistory(History hist) {
        hist.save();
    }

    @Override
    public void deleteHistory(History hist) {
        hist.delete();
    }

    @Override
    public void deleteAllHistory() {
        History.deleteAll(History.class);
    }

    @Override
    public List<History> retrieveAllHistory() {
        return History.listAll(History.class);
    }

    @Override
    public History retrieveById(History hist) {
        return History.findById(History.class, hist.getId());
    }
}
