package com.bridgelabz.programs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageRetreiving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from imgtable");
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Blob blob=resultset.getBlob(2);
				byte[] bytes=blob.getBytes(1, (int) blob.length());
				
				FileOutputStream file=new FileOutputStream("/home/bridgeit/Desktop/12.jpg");
				file.write(bytes);
				file.close();
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
