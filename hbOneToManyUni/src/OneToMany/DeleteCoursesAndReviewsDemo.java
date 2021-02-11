package OneToMany;


import OneToMany.demo.entity.Course;
import OneToMany.demo.entity.Instructor;
import OneToMany.demo.entity.InstructorDetail;
import OneToMany.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCoursesAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            //start transaction
            session.beginTransaction();

            //get

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println("Deleting course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            //delete course with cascade delete
            session.delete(tempCourse);
            session.getTransaction().commit();
            System.out.println("done!");
        }finally {

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
