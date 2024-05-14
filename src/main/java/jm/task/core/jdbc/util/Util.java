package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

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
}
