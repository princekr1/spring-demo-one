package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;
import com.example.prince.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			
			//Get Instructor by Primary Key Id
			int theID=1;
			Instructor tempInstructor=session.get(Instructor.class, theID);
			
			System.out.println("Found Instructor : "+tempInstructor);
			/**
			 * Note It will delete both the Objects Instructor/InstructorDetails
			 * Due to CascadeType.ALL
			 */
			//Delete the Instructor
			System.out.println("Deleting Instructor : "+tempInstructor);
			if(tempInstructor!=null) {
				session.delete(tempInstructor);
			}
			
			//Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			System.out.println("Done.....");
			
		}finally {
			factory.close();
		}

	}

}
