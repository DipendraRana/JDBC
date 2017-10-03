package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class BatchProcessingUsingPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer;
		Scanner scanner=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("insert into student values(?,?,?)");
			connection.setAutoCommit(false);
			do {
				System.out.println("Enter the students Name:");
				String sname=scanner.nextLine();
				System.out.println("Enter the "+sname+"'s Id:");
				int sid=Integer.parseInt(scanner.nextLine());
				System.out.println("Enter the "+sname+"'s Course");
				String scourse=scanner.nextLine();
				preparedStatement.setInt(1, sid);
				preparedStatement.setString(2, sname);
				preparedStatement.setString(3, scourse);
				preparedStatement.addBatch();
				System.out.println("Want to enter the new details(yes/no):");
				answer=scanner.nextLine();
			}while(answer.equals("yes"));
			preparedStatement.executeBatch();
			System.out.println("Decide commit or abort");
			String decide=scanner.nextLine();
			if(decide.equals("commit"))
				connection.commit();
			else
				connection.rollback();
			scanner.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
