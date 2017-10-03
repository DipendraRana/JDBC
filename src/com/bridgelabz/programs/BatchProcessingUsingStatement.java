package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingUsingStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			connection.setAutoCommit(false);
			Statement statement=connection.createStatement();
			statement.addBatch("insert into student values(13,'Shasti','Civil')");
			statement.addBatch("insert into student values(12,'Ravi','Civil')");
			statement.executeBatch();
			connection.commit();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
