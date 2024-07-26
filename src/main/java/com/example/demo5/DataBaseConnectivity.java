package com.example.demo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectivity {
	
	private static final String URL = "jdbc:mysql://localhost:3306/Bloodbank";
    private static final String USER = "root";
    private static final String PASSWORD = "Pass5742.";
	
    public Connection databaseLink;

    public Connection getConnection() {
    	Connection connection = null;
    	try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
//        String databasename = "Bloodbank";
//        String databaseuser = "root";
//        String databasepassword = "Pass5742.";
//        String url = "jdbc:mysql://localhost/" + databasename;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            databaseLink = DriverManager.getConnection(url,databaseuser,databasepassword);
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getCause();
//
//        }
//        return databaseLink;
    }


}
