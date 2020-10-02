package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent=new Student("Paul","wall","paulwall@gmail.com");
			
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			
			//Save the Student Object
			System.out.println("Saving Object..........");
			session.save(tempStudent);
			
			//Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			System.out.println("Done.....");
			
		}finally {
			factory.close();
		}

	}

}
