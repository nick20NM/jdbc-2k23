package com.alpha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// this program checks whether java app is connected with db or not
public class JDBC1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		
		System.out.println(connection.isClosed() ? "Connection is closed" : "Connection established");
		
	}

}
