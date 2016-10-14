package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;

/**
 * Created by dasan on 10/12/2016.
 */

public interface RegistryDAOInterface {

    void createRegistry(Registry reg);
    void updateRegistry(Registry reg);
    void deleteRegistry(Registry reg);
    void deleteAllRegistries();
    Registry retrieveRegistryById(Registry reg);
    List<Registry> retrieveAllRegistries();
}
