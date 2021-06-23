package com.sapient.movieBooking.utilities;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

@Component
public class GetConnection {

    public static Connection getMySQL() {
    	
        ResourceBundle rb = ResourceBundle.getBundle("db");
        String driver = rb.getString("driver");
        String url = rb.getString("url");
        String userName = rb.getString("userName");
        String password = rb.getString("password");
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


}
