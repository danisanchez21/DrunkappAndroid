package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

//import ContactDAOInterface;

/**
 * Created by jfinlay on 10/27/2016.
 */

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

public class Contact extends SugarRecord
{
    private String name;
    private int phoneNumber;

    public Contact() {}

    public Contact(String _name, int _number)
    {
        name = _name;
        phoneNumber = _number;
    }

    // Accessors

    public String getName(){ return name;}
    public int getPhoneNumber() { return phoneNumber;}

    // Mutators

    public void setName(String _newname){ name = _newname;}
    public void setPhoneNumber(int _newnumber) { phoneNumber = _newnumber;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (phoneNumber != contact.phoneNumber) return false;
        return name != null ? name.equals(contact.name) : contact.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + phoneNumber;
        return result;
    }
}
