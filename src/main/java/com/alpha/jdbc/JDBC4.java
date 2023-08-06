package com.alpha.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// program to insert image in database table
// in real time projects we store image in file system, & save the image name in db table
public class JDBC4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		// load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		
		// create query
		String query="insert into image(pic) values(?)";
		
		// get the PreparedStatement object
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		// get image from path
		FileInputStream stream = new FileInputStream("D:\\java imp notes 2023\\jdbc\\pic\\dora2.png");
		
		// set the values to query
		preparedStatement.setBinaryStream(1, stream, stream.available());
		
		byte result=100;
		try {
			result = (byte)preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
		
		System.out.println(result);
		System.out.println(result==1 ? "image saved successfully to db" : "something went wrong");
		
		// close the connection
		connection.close();
	}

}
