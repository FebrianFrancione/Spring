package OneToOneBi.test.hbOneBi.demo;

import OneToOneBi.demo.hibernate.demo.entity.Instructor;
import OneToOneBi.demo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hbOneToOneBi/src/hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //start transaction
            session.beginTransaction();

            //get instructor detail
            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("tempInstrcutorDetail: " + tempInstructorDetail);

            System.out.println("the Asscoiated instructor detail: " + tempInstructorDetail.getInstructor());

            //now delete
            System.out.println("Deleting tempInstructorDetailL: " + tempInstructorDetail);

            //remove associated obj reference
            //brak bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

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
