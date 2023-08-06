package com.alpha.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// program to update record in database table
public class JDBC6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		// load the driver & create connection
		Connection connection = ConnectionProvider.getConnection();

		// create query
		String query = "update student set name=?, city=? where id=?";

		// get input from the console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter new name:");
		String name = reader.readLine();
		
		System.out.println("Enter new city:");
		String city = reader.readLine();
		
		System.out.println("Enter student id:");
		int id = Integer.parseInt(reader.readLine()); 

		// get the PreparedStatement object
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		// set the values to query
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, city);
		preparedStatement.setInt(3, id);

		byte result = 100;
		try {
			result = (byte) preparedStatement.executeUpdate();
		} catch (Exception e) {

		}

		System.out.println(result);
		System.out.println(result == 1 ? "record updated successfully to db" : "something went wrong");

		// close the connection
		connection.close();
	}

}
