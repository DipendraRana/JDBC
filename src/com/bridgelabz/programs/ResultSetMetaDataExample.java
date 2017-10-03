package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

public class ResultSetMetaDataExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
			ResultSetMetaData resultSetMetaData=(ResultSetMetaData) preparedStatement.getMetaData();
			
			System.out.println("Total No of rows: "+resultSetMetaData.getColumnCount());
			System.out.println("Cloumn name of 1'st cloumn: "+resultSetMetaData.getColumnName(1));
			System.out.println("Cloumn name of 2'nd cloumn: "+resultSetMetaData.getColumnName(2));
			System.out.println("Cloumn name of 3'nd cloumn: "+resultSetMetaData.getColumnName(3));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
