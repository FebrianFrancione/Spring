package hbOneToOneBi.src.OneToOneBi.test.hbOneBi.demo;

import OneToOneBi.demo.hibernate.demo.entity.Instructor;
import OneToOneBi.demo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("src/hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //start transaction
            session.beginTransaction();
            //get instructor br primary key/id
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Found Instructor: " + tempInstructor);
            //delete the instrcutros
            if(tempInstructor != null){
                System.out.println("Deleting : "  + tempInstructor);
                session.delete(tempInstructor);
            }

            //commit trasnaction
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}
