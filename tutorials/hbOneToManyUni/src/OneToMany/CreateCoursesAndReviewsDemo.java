package hbOneToManyUni.src.OneToMany;



import OneToMany.demo.entity.Course;
import OneToMany.demo.entity.Instructor;
import OneToMany.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import OneToMany.demo.entity.InstructorDetail;


public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{



            //start transaction
            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to score one mill");

            tempCourse.addReview(new Review("Great game!"));

            tempCourse.addReview(new Review("Terrible game!"));

            tempCourse.addReview(new Review("Decent game!"));


            System.out.println("saving course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);



            session.getTransaction().commit();
            System.out.println("done!");
        }finally {

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
