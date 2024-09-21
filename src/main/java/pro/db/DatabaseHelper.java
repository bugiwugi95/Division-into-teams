package pro.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private Connection connection;

    public DatabaseHelper(String db) {
        try {
            String user = "postgres";
            String password = "123w123";
            this.connection = DriverManager.getConnection(db, user, password);
            System.out.println("База подключена успешно");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения базы данных");
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }


}
