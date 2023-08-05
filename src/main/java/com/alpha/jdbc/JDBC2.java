package com.alpha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// program to create table in db
public class JDBC2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
		
		// create query
		String query="create table student(id int primary key auto_increment, name varchar(100) not null, city varchar(100))";
		
		// create statement
		Statement statement = connection.createStatement();
		
		int result=100;
		try {
			result = statement.executeUpdate(query);
		} catch (Exception e) {
		}
		
		System.out.println(result);
		System.out.println(result==0 ? "table created successfully" : "something went wrong");
		
		// close the connection
		connection.close();
	}

}
