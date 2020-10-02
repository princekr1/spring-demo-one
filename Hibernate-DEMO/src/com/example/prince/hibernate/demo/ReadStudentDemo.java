package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			//Create the Student Object
			System.out.println("Creating a new Student Object......... ");
			Student tempStudent=new Student("Erza","Scarlet","erzascarlet@gmail.com");
			
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			
			//Save the Student Object
			System.out.println("Saving Object..........");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			
			//My New Code
			System.out.println("Saved Student . Generated ID : "+tempStudent.getId());
			
			//Now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve Student based on the id : Primary Key
			System.out.println("\nGetting Student with ID: "+tempStudent.getId());
			Student myStudent=session.get(Student.class, tempStudent.getId());
			System.out.println("Fetch Student From Database :"+myStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.....");
			
		}finally {
			factory.close();
		}

	}

}
