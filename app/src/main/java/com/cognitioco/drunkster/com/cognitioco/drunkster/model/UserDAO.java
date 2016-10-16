package com.cognitioco.drunkster.com.cognitioco.drunkster.model;


public class UserDAO implements UserDAOInterface {

    @Override
    public void createUser(User user) {
        user.save();
    }

    @Override
    public void updateUser(User user) {
        user.save();
    }

    @Override
    public void deleteUser(User user) {
        user.delete();
    }

    @Override
    public User retrieveUserById(User user) {
        return User.findById(User.class, user.getId());
    }

    @Override
    public User retrieveUserByName(User user) {
        return (User) User.find(User.class, "where name = ?", user.getName());
    }
}
