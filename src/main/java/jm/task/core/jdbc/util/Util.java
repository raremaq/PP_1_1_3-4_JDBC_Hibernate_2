package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                settings.put("hibernate.connection.username", "user");
                settings.put("hibernate.connection.password", "pass");
                settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
                settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Connected to the database successfully");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connected to the database failed");
            }
        }
        return sessionFactory;
    }

        public static void closeSession(SessionFactory sessionFactory) {
            if (sessionFactory != null && sessionFactory.isOpen()) {
                 try {
                     sessionFactory.close();
                    System.out.println("Connection close");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Connection close ERROR");
                }
            }
        }


//    private static final String URL = "jdbc:mysql://localhost:3306/test";
//    private static final String USERNAME = "user";
//    private static final String PASSWORD = "pass";
//
//    private Util() {
//    }
//
//    public static Connection getConnection() {
//        // реализуйте настройку соеденения с БД
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("Connection OK");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.print("Connection ERROR");
//        }
//        return connection;
//    }
//
//    public static void closeConnection(Connection connection) {
//        if (connection != null) {
//            try {
//                connection.close();
//                System.out.println("Connection close");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println("Connection close ERROR");
//            }
//        }
//    }
}
