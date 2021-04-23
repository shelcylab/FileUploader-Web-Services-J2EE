package com.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author shelc
 */
public class DbUtil {

    private static Connection connection = null;

    public static Connection initiateDBConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String db_URL = "jdbc:mysql://localhost:3306/imagedatadb?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
            String db_username = "root";
            String db_password = "root123";

            conn = DriverManager.getConnection(db_URL, db_username, db_password);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return conn;
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("com.mysql.cj.jdbc.Driver");
                String url = prop.getProperty("jdbc:mysql://localhost:3306/imagedatadb?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false");
                String user = prop.getProperty("root");
                String password = prop.getProperty("root123");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }

}
