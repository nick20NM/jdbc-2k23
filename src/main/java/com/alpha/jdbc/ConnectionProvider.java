package com.alpha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton class, only one object can be created
public class ConnectionProvider {

	private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if (connection==null) {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		}
		
		return connection;
	}
}
