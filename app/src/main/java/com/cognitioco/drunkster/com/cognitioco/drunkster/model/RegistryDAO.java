package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import java.util.List;

/**
 * Created by dasan on 10/12/2016.
 */

public class RegistryDAO implements RegistryDAOInterface
{
    @Override
    public void createRegistry(Registry reg) {
        reg.save();
    }

    @Override
    public void updateRegistry(Registry reg) {
        reg.save();

}
    @Override
    public void deleteRegistry(Registry reg) {
        reg.delete();
    }

    @Override
    public void deleteAllRegistries() {
        Registry.deleteAll(Registry.class);
    }

    @Override
    public Registry retrieveRegistryById(Registry reg) {
        return Registry.findById(Registry.class, reg.getId());
    }

    @Override
    public List<Registry> retrieveAllRegistries() {
        return Registry.listAll(Registry.class);
    }

}
