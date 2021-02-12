package EagerLazy;


import EagerLazy.demo.hibernate.demo.entity.Course;
import EagerLazy.demo.hibernate.demo.entity.Instructor;
import EagerLazy.demo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{
            //start transaction
            session.beginTransaction();

//hibernate with hql

            int theId = 1;
            Query<Instructor> query = session.createQuery("select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId", Instructor.class);

            //set param
            query.setParameter("theInstructorId", theId);
            //execute query and get instrcutor
            Instructor tempInstuctor = query.getSingleResult();

            System.out.println("Instructor: " + tempInstuctor);


            //commit trasnaction
            session.getTransaction().commit();

            session.close();
            System.out.println("Session closed");

            //since courses are lazy loaded - should fail
            System.out.println("Courses: " + tempInstuctor.getCourses());
            System.out.println("done!");
        }finally {

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
