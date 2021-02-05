package com.test.hibernate.demo;

import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate-tutorial/src/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //use session obj to save JAVA obj
//           create 3 student objs
            System.out.println("Creating new Student obj:");
            Student tempStudent1 = new Student("john", "Smith", "john@email.com");
            Student tempStudent2 = new Student("ron", "Burg", "Ron@email.com");
            Student tempStudent3 = new Student("HaNNA", "lee", "hanna@email.com");
            //start transaction
            session.beginTransaction();
            //save the student obj
            System.out.println("saving the Student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit trasnaction
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}

