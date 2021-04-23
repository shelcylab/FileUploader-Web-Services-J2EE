package service;

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
}

    


