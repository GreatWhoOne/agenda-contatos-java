package interfaces;

import entities.Contact;

import java.util.List;

public interface ICrud {
    boolean saveContact(Contact ct);
    boolean updateContact(Contact ct);
    Contact deleteContact(int idContact);
    List<Contact> listContact();
    Contact listContactById(int id);
}
