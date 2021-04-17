package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;

public class CreateInsructorDemo {

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
		
			//Create Objects
			System.out.println("Creating a new Instructor Object......... ");
			Instructor tempInstructor=new Instructor("Voilet","EverGarden","voiletevergarden@gmail.com");
			
			System.out.println("Creating a new InstructorDetail Object......... ");
			InstructorDetail tempInstructorDetail=new InstructorDetail("https://youtube.com/voiletEvergarden","luvtoWrite");
			
			
			//Associate the Objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			/**
			 * Note It will save both the Objects Instructor/InstructorDetails
			 * Due to CascadeType.ALL
			 */
			//Save the Student Object
			System.out.println("Saving Instructor..........: "+tempInstructor);
			session.save(tempInstructor);
			
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
