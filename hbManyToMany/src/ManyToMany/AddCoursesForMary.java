package ManyToMany;


import ManyToMany.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMary {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{
            //start transaction
            session.beginTransaction();

            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("Loaded sstudent " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());

            Course tempCourse1 = new Course("Rubik's Cube - speed cube");
            Course tempCourse2 = new Course("Sony vegas");

            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            System.out.println("Saving courses ");
            session.save(tempCourse1);
            session.save(tempCourse2);


            session.getTransaction().commit();
            System.out.println("done!");
        }finally {

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
