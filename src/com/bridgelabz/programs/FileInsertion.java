package com.bridgelabz.programs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("insert into filetable values(?,?)");
			preparedstatement.setString(1, "Deep");
			File file=new File("/home/bridgeit/Desktop/RUNNING.txt");
			FileReader fileread=new FileReader(file);
			preparedstatement.setCharacterStream(2, fileread,(int)file.length());
			preparedstatement.executeUpdate();
			fileread.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
