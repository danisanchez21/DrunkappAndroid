package com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.User;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.UserDAO;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.UserDAOInterface;

/**
 * Created by dasan on 10/15/2016.
 */

public class UserController implements UserDAOInterface {

    private UserDAO dao;

    public UserController() {
        dao = new UserDAO();
    }

    @Override
    public void createUser(User user) {
        dao.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public User retrieveUserById(User user) {
        return dao.retrieveUserById(user);
    }

    @Override
    public User retrieveUserByName(User user) {
        return dao.retrieveUserByName(user);
    }
}
