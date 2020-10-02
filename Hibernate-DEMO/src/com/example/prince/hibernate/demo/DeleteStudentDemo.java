package com.example.prince.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.prince.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			//System.out.println("Saved Student . Generated ID : "+studentID);
			
			//Now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			/*//Retrieve Student based on the id : Primary Key
			System.out.println("\nGetting Student with ID: "+studentID);
			Student myStudent=session.get(Student.class, studentID);
			System.out.println("Fetch Student From Database :"+myStudent);
			
			//Delete The Student
			System.out.println("Deleting Student : "+myStudent);
			session.delete(myStudent);
			System.out.println("Deleted Student with Id:"+studentID);
			*/ 
			//Delete student id=2
			System.out.println("\n\nDeleting student with ID =2");
			session.createQuery("delete from Student where id=2")
			.executeUpdate();
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.....");
			
		}finally {
			factory.close();
		}

	}

}
