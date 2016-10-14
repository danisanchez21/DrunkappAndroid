package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

/**
 * Created by dasan on 10/12/2016.
 */

public interface UserDAOInterface {

    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User retrieveUserById(User user);
    User retrieveUserByName(User user);
}
