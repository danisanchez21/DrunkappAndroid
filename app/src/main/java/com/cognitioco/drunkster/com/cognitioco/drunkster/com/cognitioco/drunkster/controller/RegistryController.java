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

    }

    @Override
    public void updateRegistry(Registry reg) {

    }

    @Override
    public void deleteRegistry(Registry reg) {

    }

    @Override
    public void deleteAllRegistries() {

    }

    @Override
    public Registry retrieveRegistryById(Registry reg) {
        return null;
    }

    @Override
    public List<Registry> retrieveAllRegistries() {
        return null;
    }
}
