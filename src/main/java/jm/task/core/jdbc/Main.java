package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        Connection connection = Util.getConnection();

        userService.createUsersTable();

        userService.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println("User с именем Name 1 добавлен в базу данных");
        userService.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println("User с именем Name 2 добавлен в базу данных");
        userService.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println("User с именем Name 3 добавлен в базу данных");
        userService.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println("User с именем Name 4 добавлен в базу данных");

        userService.removeUserById(1);
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeConnection(connection);

    }
}
