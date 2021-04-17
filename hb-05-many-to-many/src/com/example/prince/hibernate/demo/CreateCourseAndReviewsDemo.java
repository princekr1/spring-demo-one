package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;
import com.example.prince.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			
			//Create a Course
			Course tempCourse=new Course("Pacman - How To Score One Million Points");
			
			//add Some Reviews
			Review review1=new Review("Great Courses .... loved it");
			Review review2=new Review("Cool Course, Well Done");
			Review review3=new Review("Need Improvement : Update The Coourse Per Requirement");
			
			tempCourse.addReviews(review1);
			tempCourse.addReviews(review2);
			tempCourse.addReviews(review3);
			
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
