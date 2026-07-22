package com.co.basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    static Properties props = new Properties();
    FileInputStream fis = new FileInputStream("config.properties");
    static String URL = props.getProperty("db.url");
    static String USER = props.getProperty("db.user");
    static String PASSWORD = props.getProperty("db.password");

    public DatabaseConnection() throws FileNotFoundException {
    }

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );

    }

}