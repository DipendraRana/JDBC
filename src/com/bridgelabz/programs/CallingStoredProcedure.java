package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class CallingStoredProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			CallableStatement callablestatement=(CallableStatement) connection.prepareCall("{call insertinto(?,?,?)}");
			callablestatement.setInt(1, 5);
			callablestatement.setString(2, "Shastri");
			callablestatement.setString(3, "IT");
			callablestatement.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
