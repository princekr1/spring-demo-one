package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.prince.hibernate.demo.entity.Course;
import com.example.prince.hibernate.demo.entity.Instructor;
import com.example.prince.hibernate.demo.entity.InstructorDetail;

public class FetchJoinHQLDemo {

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
			
			//Option 2 : Hibernate Query with HQL
			
			//Get the instructor from db
			int theId=1;
			
			Query<Instructor> query = session.createQuery(
					"Select i from Instructor i " + "Join Fetch i.courses " + "where i.id=:theInstructorId",
					Instructor.class);
			
			//Set parameter on Query
			query.setParameter("theInstructorId",1);
			
			//Execute Query and get the instructor
			Instructor tempInstructor=query.getSingleResult();
			
			System.out.println("luv2Code : Instructor : "+tempInstructor);
			
			//Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			
			//close the session
			session.close();
			System.out.println("\nluv2Code : the session is now closed \n");
			
			//get the courses for he Instructor
			System.out.println("luv2code : Courses :"+tempInstructor.getCourses());
			
			System.out.println("luv2Code : Done.....");
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
