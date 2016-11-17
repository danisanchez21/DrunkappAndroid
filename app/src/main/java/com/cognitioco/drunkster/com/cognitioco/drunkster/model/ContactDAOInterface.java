package com.cognitioco.drunkster.com.cognitioco.drunkster.model;
import java.util.List;

/**
 * Created by jfinlay on 10/27/2016.
 */

public interface ContactDAOInterface
{
    void createContact(Contact _contact);
    void updateContact(Contact _contact);
    void deleteContact(Contact _contact);
    void deleteAllContacts();
    Contact retrieveContactByID(Contact _contact);
    Contact retrieveContactByName(Contact _contact);
    List<Contact> retrieveContacts();



}
