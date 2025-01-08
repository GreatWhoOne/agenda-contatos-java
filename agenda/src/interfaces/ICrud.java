package interfaces;

import entities.Contact;

import java.util.List;

public interface ICrud {
    boolean saveContact(Contact ct);
    boolean updateContact(Contact ct);
    void deleteContact(int idContact);
    List<Contact> readContact();
    Contact readContactById(int id);
}
