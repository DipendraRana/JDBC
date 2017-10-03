package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class PreparedStatementExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","root","root");
			preparedStatement=(PreparedStatement) connection.prepareStatement("insert into student values (?,?,?)");
			Scanner scanner=new Scanner(System.in);
			String decision;
			do {
				System.out.print("Enter the Student Name:");
				String studentName=scanner.nextLine();
				System.out.print("Enter the "+studentName+"'s ID:");
				int studentID=Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the "+studentName+"'s Course:");
				String studentCourse=scanner.nextLine();
				
				preparedStatement.setInt(1, studentID);
				preparedStatement.setString(2, studentName);
				preparedStatement.setString(3, studentCourse);
				int index=preparedStatement.executeUpdate();
				System.out.println(index+" record affected");
				
				
				System.out.println("Do you wnat to add more data to your database(yes/no):");
				decision=scanner.nextLine();
				decision=decision.toLowerCase();
			}while(decision.equals("yes"));
			scanner.close();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
