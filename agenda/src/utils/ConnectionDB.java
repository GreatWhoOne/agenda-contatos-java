package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/curso-db-java", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void finishConnection(){
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
