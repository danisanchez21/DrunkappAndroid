package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

//import ContactDAOInterface;

/**
 * Created by jfinlay on 10/27/2016.
 */

import java.util.List;

public class ContactDAO implements ContactDAOInterface
{

    @Override
    public void createContact(Contact _contact){ _contact.save();}

    @Override
    public void updateContact(Contact _contact){ _contact.save();}

    @Override
    public void deleteContact(Contact _contact){ _contact.delete();}

    @Override
    public void deleteAllContacts() {
        Contact.deleteAll(Contact.class);
    }

    @Override
    public Contact retrieveContactByID(Contact _contact) {return Contact.findById(Contact.class, _contact.getId());}

    @Override
    public Contact retrieveContactByName(Contact _contact) {return (Contact) Contact.find(Contact.class, "where name = ?", _contact.getName()); }

    @Override
    public List<Contact> retrieveContacts() {
        return Contact.listAll(Contact.class);
    }

}
