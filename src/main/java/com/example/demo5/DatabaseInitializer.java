package com.example.demo5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
	 private static final String[] SQL_STATEMENTS = {
		        "CREATE TABLE IF NOT EXISTS DonorLogin (" +
		        "id INT AUTO_INCREMENT PRIMARY KEY, " +
		        "name VARCHAR(255) NOT NULL, " +
		        "age INT NOT NULL, " +
		        "email VARCHAR(255) NOT NULL, " +
		        "contact VARCHAR(255) NOT NULL, " +
		        "address VARCHAR(255) NOT NULL, " +
		        "blood_group VARCHAR(3) NOT NULL, " +
		        "password VARCHAR(255) NOT NULL, " +
		        "Notification DATE" +
		        ");",

		        "CREATE TABLE IF NOT EXISTS BloodTransfusionRequests (" +
		        "id INT AUTO_INCREMENT PRIMARY KEY, " +
		        "donor_name VARCHAR(255) DEFAULT NULL, " +
		        "blood_type VARCHAR(3) NOT NULL, " +
		        "quantity INT NOT NULL, " +
		        "request_date DATE DEFAULT (CURRENT_DATE)" +
		        ");",

		        "CREATE TABLE IF NOT EXISTS blood_drives (" +
		        "id INT AUTO_INCREMENT PRIMARY KEY, " +
		        "location VARCHAR(255) NOT NULL, " +
		        "date DATE NOT NULL, " +
		        "time TIME NOT NULL" +
		        ");",
		        
		        "CREATE TABLE IF NOT EXISTS bloodinventory (" +
		        		"id INT AUTO_INCREMENT PRIMARY KEY, " +
		        		"blood_type VARCHAR(3) NOT NULL, " +
		        		"quantity INT NOT NULL, " +
		        		"count_column INT NOT NULL, " +  // Add the new column here
		        		"last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
		        		");",
				
				"CREATE TABLE IF NOT EXISTS blood_donations (" +
				"id INT AUTO_INCREMENT PRIMARY KEY, " +
				"donor_name VARCHAR(255) NOT NULL,"+
				"blood_type VARCHAR(3) NOT NULL, " +
				"donation_date DATE DEFAULT (CURRENT_DATE)" +
				");"

		    };
	 		
	 private static final String[] INITIAL_INVENTORY_DATA = {
		        "INSERT INTO bloodinventory (blood_type, quantity) VALUES " +
		        "('A+', 0), " +
		        "('A-', 0), " +
		        "('B+', 0), " +
		        "('B-', 0), " +
		        "('AB+', 0), " +
		        "('AB-', 0), " +
		        "('O+', 0), " +
		        "('O-', 0) " +
		        "ON DUPLICATE KEY UPDATE blood_type = blood_type;"
		    };
	 
		    public static void initializeDatabase() {
		        DataBaseConnectivity connection = new DataBaseConnectivity();
		        try (Connection connectDB = connection.getConnection();
		             Statement statement = connectDB.createStatement()) {
		            for (String sql : SQL_STATEMENTS) {
		                statement.execute(sql);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
}
