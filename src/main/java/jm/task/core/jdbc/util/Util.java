package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    private Util() {
    }

    public static Connection getConnection() {
        // реализуйте настройку соеденения с БД
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Connection ERROR");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection close");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection close ERROR");
            }
        }
    }
}
