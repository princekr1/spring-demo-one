package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			int studentID=1;
			//My New Code
			System.out.println("Saved Student . Generated ID : "+studentID);
			
			//Now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve Student based on the id : Primary Key
			System.out.println("\nGetting Student with ID: "+studentID);
			Student myStudent=session.get(Student.class, studentID);
			System.out.println("Fetch Student From Database :"+myStudent);
			
			System.out.println("Updating Student :.................");
			myStudent.setFirstName("Grey");
			myStudent.setLastName("Fullbuster");
			
			//Commit the transaction
			session.getTransaction().commit();
			
			//New Code
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Update email of all Students
			System.out.println("Updating Email of Student having firstName as Grey and lastName as 'Fullbuster'");
			session.createQuery("update Student set email='greyfullbuster@gmail.com' where firstName='Grey' and lastName='Fullbuster'")
			.executeUpdate();
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.....");
			
		}finally {
			factory.close();
		}

	}

}
