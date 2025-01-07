import utils.ConnectionDB;

public class Agenda {
    public static void main(String[] args) {

       if(ConnectionDB.getConnection() != null) {
           System.out.println("Conected");
       }

    }
}