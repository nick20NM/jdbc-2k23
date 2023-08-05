package com.alpha.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// program to insert data/records in database table
public class JDBC3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		// load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		
		// create query
		String query="insert into student(name, city) values(?, ?)";
		
		// get the PreparedStatement object
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		// getting input from the user using console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter name:");
		String name = reader.readLine();
		
		System.out.println("enter city:");
		String city = reader.readLine();
		
		// set the values to query
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, city);
		
		byte result=100;
		try {
			result = (byte)preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
		
		System.out.println(result);
		System.out.println(result==1 ? "record/data inserted successfully" : "something went wrong");
		
		// close the connection
		connection.close();
	}

}
