package com.alpha.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

// program to insert image (largeblob) in database table
// in real time projects we store image in file system, & save the image name in db table
public class JDBC5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		// load the driver & create connection
		Connection connection = ConnectionProvider.getConnection();

		// create query
		String query = "insert into image(pic) values(?)";

		// get the PreparedStatement object
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		// select file using JFileChooser
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		System.out.println("file="+file);

		// get image from file
		FileInputStream stream = new FileInputStream(file);
		System.out.println("stream="+stream);

		// set the values to query
		preparedStatement.setBinaryStream(1, stream, stream.available());

		byte result = 100;
		try {
			result = (byte) preparedStatement.executeUpdate();
		} catch (Exception e) {

		}

		System.out.println(result);
		System.out.println(result == 1 ? "image saved successfully to db" : "something went wrong");
		JOptionPane.showMessageDialog(null, result == 1 ? "image saved successfully to db" : "something went wrong");

		// close the connection
		connection.close();
	}

}
