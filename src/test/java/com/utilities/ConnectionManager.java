package com.utilities;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Log4j
public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/Framework?allowPublicKeyRetrieval=true&useSSL=false";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "Welcome123";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                log.info("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            log.info("Driver not found.");
        }
        return con;
    }
}