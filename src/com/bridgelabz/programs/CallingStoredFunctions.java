package com.bridgelabz.programs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallingStoredFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			CallableStatement callablestatement=connection.prepareCall("{?=call sum4(?,?)}");
			callablestatement.setInt(2, 3);
			callablestatement.setInt(3, 4);
			callablestatement.registerOutParameter(1, Types.INTEGER);
			callablestatement.executeUpdate();
			System.out.println(callablestatement.getInt(1));
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
