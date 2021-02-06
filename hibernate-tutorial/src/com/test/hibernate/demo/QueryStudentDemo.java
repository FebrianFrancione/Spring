package com.test.hibernate.demo;

import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate-tutorial/src/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //start transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from com.demo.hibernate.demo.entity.Student").list();

            displayStudents(theStudents);

            //query students: lastname = 'Doe'
            //query is underlined in red but still works - not sure how to resolve this
            theStudents = session.createQuery("from com.demo.hibernate.demo.entity.Student s where s.lastName = 'Ducc'").list();

            System.out.println("Students with last name smith");
            displayStudents(theStudents);


            //query Students: lastName = 'Ducc' OR FirstName ='Bonita'
            theStudents = session.createQuery("from com.demo.hibernate.demo.entity.Student s where s.lastName='Ducc' OR s.firstName = 'Bonita'").list();

            System.out.println("Students with last name Ducc or first name Bonita");
            displayStudents(theStudents);


            //query students where email Like %paul@email.com

            theStudents = session.createQuery("from com.demo.hibernate.demo.entity.Student s where s.email LIKE '%paul@email.com'").list();
            System.out.println("Students with email LIKE paul@email.com");
            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }
}
