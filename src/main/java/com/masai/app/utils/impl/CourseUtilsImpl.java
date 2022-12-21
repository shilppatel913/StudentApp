package com.masai.app.utils.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.masai.app.entity.Course;
import com.masai.app.entity.Student;
import com.masai.app.utils.CourseUtils;

public class CourseUtilsImpl implements CourseUtils {

	@Override
	public List<Course> getAllCourses() {
		final String url="jdbc:mysql://localhost:3306/studentdb";
		final String username="root";
		final String password="Sql@1234";
		List<Course> courses=new ArrayList<>();
	
		//let us connect to our database with the above details
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="select * from course";
			Connection connection=DriverManager.getConnection(url,username,password);
			
			if(connection!=null) {
				Statement stmt=connection.createStatement();
				ResultSet result=stmt.executeQuery(query);
				
				while(result.next()) {
					Course course=new Course();
					course.setId(result.getInt("id"));
					course.setName(result.getString("name"));
					course.setDuration(result.getString("duration"));
					courses.add(course);
				}
				return courses;
			}
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Not found ");
		}catch(SQLException e) {
			System.out.println("Could not connect to the database");
		}
		return courses;
		
	}

}
