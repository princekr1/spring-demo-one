package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;
import com.example.prince.hibernate.demo.entity.Review;
import com.example.prince.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//Create a Course
			Course tempCourse=new Course("Pacman - How To Score One Million Points");
			
			//save the courses
			System.out.println("\n Saving the Course ...");
			session.save(tempCourse);
			System.out.println("Saved the Course : "+tempCourse);
			
			//Create Some students
			Student tempStudent1=new Student("John","Doe","john@luv2code.com");
			Student tempStudent2=new Student("Mary","public","mary@luv2code.com");
			
			//add Some students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			System.out.println("\n saving the Students....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved Students :"+tempCourse.getStudents());
			
			//save the Course ... and leverage the cascade all
			
			System.out.println("Saving the Course :");
			System.out.print(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
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
