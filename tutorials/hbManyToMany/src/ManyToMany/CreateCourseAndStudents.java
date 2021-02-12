package hbManyToMany.src.ManyToMany;


import ManyToMany.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudents {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{



            //start transaction
            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to score one mill");


            System.out.println("\nSaving the course...");
            session.save(tempCourse);
            System.out.println("Saved the course " + tempCourse);

            Student tempStudent1 = new Student("John", "Doe", "joh@mail.com");
            Student tempStudent2 = new Student("Mary", "Pie", "mary@mail.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("Saving students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("saved students " + tempCourse.getStudents());


            session.getTransaction().commit();
            System.out.println("done!");
        }finally {

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
