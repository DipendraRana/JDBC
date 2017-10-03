package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaDataExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			DatabaseMetaData databaseMetaData=connection.getMetaData();
			String[] table= {"TABLE"};
			ResultSet resultSet=databaseMetaData.getTables(null, null, null, table);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(3));
			}
			
			/*System.out.println("Database Driver Name is: "+databaseMetaData.getDriverName());
			System.out.println("Database Driver Version is: "+databaseMetaData.getDriverVersion());
			System.out.println("Database User Name is: "+databaseMetaData.getUserName());
			System.out.println("Database Product Name is: "+databaseMetaData.getDatabaseProductName());
			System.out.println("Database Product Version is: "+databaseMetaData.getDatabaseProductVersion());
			System.out.println("Database url is: "+databaseMetaData.getURL());*/
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
