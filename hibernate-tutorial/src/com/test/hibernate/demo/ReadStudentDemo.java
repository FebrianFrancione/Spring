package com.test.hibernate.demo;

import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate-tutorial/src/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //use session obj to save JAVA obj
//           create student obj
            System.out.println("Creating new Student obj:");
            Student tempStudent = new Student("Daffy", "Ducc", "paul@email.com");

            //start transaction
            session.beginTransaction();
            //save the student obj
            System.out.println("saving the Student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit trasnaction
            session.getTransaction().commit();

            //New Code

            //find out the student's id: primary key
            System.out.println("Saved Student. Generated id: " + tempStudent.getId());

            //get sessions new and start transaction.
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get Complete: " + myStudent);
            //commit thetransaction

            session.getTransaction().commit();

            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}
