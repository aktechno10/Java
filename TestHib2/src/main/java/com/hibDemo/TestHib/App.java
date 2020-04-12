package com.hibDemo.TestHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
    	StudName sn=new StudName();
    	sn.setFname("Ajinkya");
    	sn.setMname("Ravindra");
    	sn.setLname("Kulkarni");
    	
    	Test t=new Test();
    	t.setId(104);
    	t.setAname(sn);
    	t.setSclass("MCS");
    	
		/*
		 * Configuration c=new
		 * Configuration().configure().addAnnotatedClass(Test.class); SessionFactory
		 * sf=c.buildSessionFactory(); Session s=sf.openSession();
		 * 
		 * Transaction tx= s.beginTransaction(); s.save(t); //t=(Test) s.get(Test.class,
		 * 102); tx.commit();
		 */
    	//Another way of doing same above stuff is as below
    	
    	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Test.class)
    			.buildSessionFactory();
    	Session session = factory.getCurrentSession();
    	
    	//best way is to handle transaction in try block
    	try {
    		//begin transaction
    		session.beginTransaction();
    		
    		//save object 
    		session.save(t);
    		
    		//commit transaction
    		session.getTransaction().commit();
    	}finally {
			
		}
    }
}
