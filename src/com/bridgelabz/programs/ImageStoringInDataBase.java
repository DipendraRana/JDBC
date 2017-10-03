package com.bridgelabz.programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageStoringInDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into imgtable values(?,?)");
			preparedStatement.setString(1, "Deep");
			
			FileInputStream file=new FileInputStream("/home/bridgeit/Desktop/1234.jpg");
			preparedStatement.setBinaryStream(2, file, file.available());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
