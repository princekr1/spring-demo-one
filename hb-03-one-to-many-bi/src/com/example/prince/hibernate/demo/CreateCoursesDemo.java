package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			
			//Get the instructor from db
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class,theId);
			
			//Create some courses
			Course course1=new Course("Air guitar - The Ultimate Guide");
			Course course2=new Course("The Pinball Masterclass");
			
			//add courses to instructor
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			
			//save the courses
			session.save(course1);
			session.save(course2);
			
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
