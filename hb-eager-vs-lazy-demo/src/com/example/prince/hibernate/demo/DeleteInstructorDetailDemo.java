package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;
import com.example.prince.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();

			//Get the instructor Detail
			
			int theId=3;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,theId);
			
			//Print the instructor Detail
			System.out.println("Instructor Detail :"+tempInstructorDetail);
			
			//Print the associated Instructor
			System.out.println("The associate Instructor:"+tempInstructorDetail.getInstructor());
			
			//remove the associated object reference
			//break bi-directional link
			System.out.println("Breaking the bi-direction link:");
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			//Now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetails: 	"+tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			
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
