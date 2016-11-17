package com.cognitioco.drunkster.com.cognitioco.drunkster.com.cognitioco.drunkster.controller;

import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Contact;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.ContactDAO;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.ContactDAOInterface;

import java.util.List;

/**
 * Created by jfinlay on 11/1/2016.
 */

public class ContactController implements ContactDAOInterface
{
    ContactDAO dao;

    public ContactController() {
        dao = new ContactDAO();
    }

    @Override
    public void createContact(Contact _contact) {
        dao.createContact(_contact);
    }

    @Override
    public void updateContact(Contact _contact) {
        dao.createContact(_contact);
    }

    @Override
    public void deleteContact(Contact _contact) {
        dao.deleteContact(_contact);
    }

    @Override
    public void deleteAllContacts() {
        dao.deleteAllContacts();
    }

    @Override
    public Contact retrieveContactByID(Contact _contact) { return dao.retrieveContactByID(_contact); }

    @Override
    public Contact retrieveContactByName(Contact _contact) { return dao.retrieveContactByName(_contact);}

    @Override
    public List<Contact> retrieveContacts() { return dao.retrieveContacts();}

}
