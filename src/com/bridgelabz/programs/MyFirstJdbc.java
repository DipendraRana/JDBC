package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		//String query="delete from student where id='1'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?user=root&password=root");
			System.out.println("Connection established with DataBase Server");
			statement=connection.createStatement();
			System.out.println("Platform Created");
			ResultSet resultset=statement.executeQuery("select * from student");
			while(resultset.next())
				System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
			//statement.executeUpdate(query);
			//System.out.println("Data Deleted successfully");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
