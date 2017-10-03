package com.bridgelabz.programs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileRetreive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("select * from filetable");
			ResultSet resultset=preparedstatement.executeQuery();
			resultset.next();
			Clob clob=resultset.getClob(2);
			Reader reader=clob.getCharacterStream();
			
			FileWriter filewrite=new FileWriter("/home/bridgeit/Desktop/copyofRUNNING.txt");
			int line;
			while((line=reader.read())!=-1) 
				filewrite.write((char)line);
			filewrite.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
