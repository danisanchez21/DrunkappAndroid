package com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Registry;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.RegistryDAO;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.RegistryDAOInterface;

import java.util.List;

/**
 * Created by dasan on 10/15/2016.
 */

public class RegistryController implements RegistryDAOInterface {

    RegistryDAO dao;

    public RegistryController() {
        dao = new RegistryDAO();
    }

    @Override
    public void createRegistry(Registry reg) {
        dao.createRegistry(reg);
    }

    @Override
    public void updateRegistry(Registry reg) {
        dao.createRegistry(reg);
    }

    @Override
    public void deleteRegistry(Registry reg) {
        dao.deleteRegistry(reg);
    }

    @Override
    public void deleteAllRegistries() {
        dao.deleteAllRegistries();
    }

    @Override
    public Registry retrieveRegistryById(Registry reg) {
        return dao.retrieveRegistryById(reg);
    }

    @Override
    public List<Registry> retrieveAllRegistries() {
        return dao.retrieveAllRegistries();
    }
}
