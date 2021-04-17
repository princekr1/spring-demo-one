package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;
import com.example.prince.hibernate.demo.entity.Review;
import com.example.prince.hibernate.demo.entity.Student;

public class DeleteCourseAndReiewsDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();

			//Get the Course Detail
			int theId=10;
			Course tempCourse=session.get(Course.class, theId);
			
			//Print the Course Detail
			System.out.println("Deleting Course Detail :"+ tempCourse);
			
			//Print the Course Reviews
			System.out.println(tempCourse.getReviews());
			
			//Delete Course and leverage Cascade All
			session.delete(tempCourse);
			
			// Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			System.out.println("Done.....");

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			//handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
