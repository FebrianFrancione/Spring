package com.test.hibernate.demo;

import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate-tutorial/src/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //use session obj to save JAVA obj
//           create student obj
            System.out.println("Creating new Student obj:");
            Student tempStudent = new Student("Paul", "Wall", "paul@email.com");

            //start transaction
            session.beginTransaction();
            //save the student obj
            System.out.println("saving the Student");
            session.save(tempStudent);

            //commit trasnaction
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}
