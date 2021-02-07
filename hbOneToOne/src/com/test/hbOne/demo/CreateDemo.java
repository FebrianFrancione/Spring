package com.test.hbOne.demo;

import com.demo.hibernate.demo.entity.Instructor;
import com.demo.hibernate.demo.entity.InstructorDetail;
import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hbOneToOne/src/hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

//            //create obj
//            Instructor tempInstructor = new Instructor("Chad", "Dhark", "dhark@mail.com");
//
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://febri.com/youtube", "coding");

            //create obj
            Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@mail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://febri.com/youtube", "guitar");

            //associate obj
            tempInstructor.setInstructorDetail(tempInstructorDetail);



            //start transaction
            session.beginTransaction();

            //save the intrcutor
            System.out.println("saving instrcutor: " + tempInstructor);
            session.save(tempInstructor);


            //commit trasnaction
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}
