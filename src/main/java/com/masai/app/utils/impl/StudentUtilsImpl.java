package com.masai.app.utils.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.masai.app.entity.Student;
import com.masai.app.utils.StudentUtils;

public class StudentUtilsImpl implements StudentUtils {

	@Override
	public List<Student> getAllStudents() {
		final String url="jdbc:mysql://localhost:3306/studentdb";
		final String username="root";
		final String password="Sql@1234";
		List<Student> students=new ArrayList<>();
	
		//let us connect to our database with the above details
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="select * from student";
			Connection connection=DriverManager.getConnection(url,username,password);
			
			if(connection!=null) {
				Statement stmt=connection.createStatement();
				ResultSet result=stmt.executeQuery(query);
				
				while(result.next()) {
					Student student=new Student();
					student.setId(result.getInt("id"));
					student.setName(result.getString("name"));
					student.setAddress(result.getString("address"));
					student.setEmail(result.getString("email"));
					student.setPassword(result.getString("password"));
					students.add(student);
					
				}
				return students;
			}
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Not found ");
		}catch(SQLException e) {
			System.out.println("Could not connect to the database");
		}
		return students;
		
	}

}
