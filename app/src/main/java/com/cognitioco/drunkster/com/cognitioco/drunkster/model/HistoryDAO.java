package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;

/**
 * Created by dasan on 10/12/2016.
 */

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
