package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;

/**
 * Created by dasan on 10/12/2016.
 */
public interface HistoryDAOInterface {

    void createHistory(History hist);
    void updateHistory(History hist);
    void deleteHistory(History hist);
    void deleteAllHistory();
    List<History> retrieveAllHistory();
    History retrieveById(History hist);
}
