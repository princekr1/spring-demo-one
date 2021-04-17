package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;
import com.example.prince.hibernate.demo.entity.Review;
import com.example.prince.hibernate.demo.entity.Student;

public class GetCoursesForMarryDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			
			//Get student marry from the database
			int theId=2;
			Student tempStudent=session.get(Student.class, theId);
			System.out.println("\nLoaded Student : "+tempStudent);
			System.out.println("Courses :"+tempStudent.getCourses());
			
			//Create more courses
			Course tempCourse1=new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2=new Course("Atari 2600 - Game Development");
			
			//Add student to the courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//Save  the courses
			System.out.println("Saving the Courses......");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			System.out.println("Done.....");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
