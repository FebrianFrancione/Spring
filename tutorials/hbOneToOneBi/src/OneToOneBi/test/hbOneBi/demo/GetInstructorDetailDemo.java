package hbOneToOneBi.src.OneToOneBi.test.hbOneBi.demo;

import OneToOneBi.demo.hibernate.demo.entity.Instructor;
import OneToOneBi.demo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("src/hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //start transaction
            session.beginTransaction();

            //get instructor detail
            int theId = 2;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("tempInstrcutorDetail: " + tempInstructorDetail);

            System.out.println("the Asscoiated instructor detail: " + tempInstructorDetail.getInstructor());

            //commit trasnaction
            session.getTransaction().commit();
            System.out.println("done!");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
