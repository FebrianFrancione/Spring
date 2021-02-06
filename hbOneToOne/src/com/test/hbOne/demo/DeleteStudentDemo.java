package com.test.hbOne.demo;

import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate-tutorial/src/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            int studentId = 1;

            //get sessions new and start transaction.
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            //new code delete
//            System.out.println("Deleting student: " + myStudent);
//            session.delete(myStudent);


            //delete studetn with id = 2
            System.out.println("delete fro mstuden where id = 2");
            session.createQuery("delete from Student where id=4").executeUpdate();

            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}
