package dao;

import entities.Contact;
import interfaces.ICrud;
import utils.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoContact implements ICrud {

    @Override
    public boolean saveContact(Contact ct) {
        String sql = "INSERT INTO tb_contatos(nome, email, fone) VALUES (?,?,?)";
        try {
            PreparedStatement stm = ConnectionDB.getConnection().prepareStatement(sql);
            stm.setString(1, ct.getName());
            stm.setString(2, ct.getEmail());
            stm.setString(3, ct.getFone());
            stm.execute();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.toString());
            return false;
        }
        finally {
            ConnectionDB.finishConnection();
        }
        return true;
    }

    @Override
    public boolean updateContact(Contact ct) {
        String sql = "UPDATE tb_contatos SET nome = ?, email = ? , fone = ? WHERE id = ?";
        try {
            PreparedStatement stm = ConnectionDB.getConnection().prepareStatement(sql);
            stm.setString(1, ct.getName());
            stm.setString(2, ct.getEmail());
            stm.setString(3, ct.getFone());
            stm.setInt(4, ct.getId());
            stm.execute();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.toString());
            return false;
        }
        finally {
            ConnectionDB.finishConnection();
        }
        return true;
    }

    @Override
    public void deleteContact(int idContact) {
        String sql = "DELETE FROM tb_contatos WHERE id = ?";
        try {
            PreparedStatement stm = ConnectionDB.getConnection().prepareStatement(sql);
            stm.setInt(1, idContact);
            stm.execute();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.toString());
        } finally {
            ConnectionDB.finishConnection();
        }
    }

    @Override
    public List<Contact> readContact() {
        String sql = "SELECT * FROM tb_contatos";
        List<Contact> contacts = new ArrayList<>();
        try {
            PreparedStatement stm = ConnectionDB.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while(rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("nome"));
                contact.setEmail(rs.getString("email"));
                contact.setFone(rs.getString("fone"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.toString());
        }
        finally {
            ConnectionDB.finishConnection();
        }
        return contacts;
    }

    @Override
    public Contact readContactById(int id) {
        Contact contact = null;
        String sql = "SELECT * FROM tb_contatos WHERE id = ?";
        try {
            PreparedStatement stm = ConnectionDB.getConnection().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                contact = new Contact(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("fone"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.toString());
        } finally {
            ConnectionDB.finishConnection();
        }
       return contact;
    }
}
