package com.masai.app;


import java.util.List;

import com.masai.app.entity.Course;
import com.masai.app.entity.Student;
import com.masai.app.utils.impl.CourseUtilsImpl;
import com.masai.app.utils.impl.StudentUtilsImpl;




/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
    	StudentUtilsImpl studentUtilsImpl=new StudentUtilsImpl();
    	CourseUtilsImpl courseUtilsImpl=new CourseUtilsImpl();
    	
    	List<Student> students=studentUtilsImpl.getAllStudents();
    	List<Course> courses=courseUtilsImpl.getAllCourses();
    	
    	System.out.println("List of Students :");
    	for(Student student:students) {
    		System.out.println("Id : "+student.getId());
    		System.out.println("Name : "+student.getName());
    		System.out.println("Address : "+student.getAddress());
    		System.out.println("Email : "+student.getEmail());
    		System.out.println("Password : "+student.getPassword());
    		System.out.println("--------------------------------------");
    	}
    	
    	System.out.println("List of Courses from the database");
    	for(Course course:courses) {
    		System.out.println("Id : "+course.getId());
    		System.out.println("Name : "+course.getName());
    		System.out.println("Duration : "+course.getDuration());
    		System.out.println("--------------------------------------");
    	}
    }
}
