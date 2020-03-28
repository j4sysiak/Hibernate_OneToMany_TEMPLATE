package pl.jaceksysiak;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Address;
import pl.jaceksysiak.entity.Employee;

public class MainClass {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
		//-----------Employee	
			Employee tmpEmployee1=new Employee();
		//	tmpEmployee.setId(1);
			tmpEmployee1.setName("Jack");

			
		//----------- Address
			Address address1 = new Address(); //(1, "Warzawa", "Poland");
			address1.setCity("Warzawa");
			address1.setCountry("Poland");
			
			Address address2 = new Address(); //(2, "Washington", "USA");
			address1.setCity("Washington");
			address1.setCountry("USA");
			
			// start a transaction
			session.beginTransaction();
			
			// save the courses
			session.save(tmpEmployee1);
			session.save(address1);
			session.save(address2);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
}
