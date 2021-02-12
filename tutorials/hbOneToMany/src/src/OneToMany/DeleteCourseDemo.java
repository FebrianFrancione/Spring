package OneToMany;


import OneToMany.demo.hibernate.demo.entity.Course;
import OneToMany.demo.hibernate.demo.entity.Instructor;
import OneToMany.demo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{
            //start transaction
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println("deleting Course: " + tempCourse);
            session.delete(tempCourse);
            //commit trasnaction
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
