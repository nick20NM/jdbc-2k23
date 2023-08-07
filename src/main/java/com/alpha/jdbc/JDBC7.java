package com.alpha.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// program to get/fetch/retrieve data from database table
public class JDBC7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		// load the driver & create connection
		Connection connection = ConnectionProvider.getConnection();

		// create query
		String query = "select * from student";

		// get the Statement object
		Statement statement = connection.createStatement();

		// get data from db table & store in ResultSet
		ResultSet set = statement.executeQuery(query);
		while (set.next()) {
			System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getString("city"));
		}

		// close the connection
		connection.close();
	}

}
