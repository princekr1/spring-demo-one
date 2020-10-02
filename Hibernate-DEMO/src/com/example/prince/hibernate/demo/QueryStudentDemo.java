package com.example.prince.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create Session
		Session session=factory.getCurrentSession();
		
		try {
		
			//Start a transaction 
			System.out.println("Begin the Transaction...........");
			session.beginTransaction();
			List<Student> theStudents=session.createQuery("from Student").list();
			
			//Display the Students
			displayStudents(theStudents);
			
			//Query Student : based on firstName
			theStudents=session.createQuery("from Student s where s.firstName='Erza'").list();
			
			System.out.println("\n\nStudent who's first name is Erza:");
			displayStudents(theStudents);
			
			//Query Student : based on firstNameand lastName
			theStudents=session.createQuery("from Student s where s.firstName='Erza' or s.lastName='Hanma'").list();
			
			System.out.println("\n\nStudent who's first name is Erza or lastName is Hanma:");
			displayStudents(theStudents);
			
			//Query Student : based on Email (Email which ends with '@gamil.com'
			theStudents=session.createQuery("from Student s where s.email like '%@gmail.com'").list();
			
			System.out.println("\n\nStudent who's Email address ends with'@gamil.com':");
			displayStudents(theStudents);
			
			
			//Commit transaction
			System.out.println("Comming transaction................");
			session.getTransaction().commit();
			System.out.println("Done.....");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
