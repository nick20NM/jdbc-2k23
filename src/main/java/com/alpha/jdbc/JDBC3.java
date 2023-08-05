package com.alpha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// program to insert data/records in database table
public class JDBC3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		
		// create query
		String query="insert into student(name, city) values(?, ?)";
		
		// get the PreparedStatement object
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		// set the values to query
		preparedStatement.setString(1, "Tom");
		preparedStatement.setString(2, "Raipur");
		
		byte result=100;
		try {
			result = (byte)preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
		
		preparedStatement.executeUpdate();
		
		System.out.println(result);
		System.out.println(result==1 ? "record inserted successfully" : "something went wrong");
		
		// close the connection
		connection.close();
	}

}
