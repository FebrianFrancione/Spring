package OneToMany;


import OneToMany.demo.hibernate.demo.entity.Course;
import OneToMany.demo.hibernate.demo.entity.Instructor;
import OneToMany.demo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{


            //create obj
            Instructor tempInstructor = new Instructor("Susan", "oub", "susan@mail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://febri.com/youtube", "gaming");

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

            //add clean up code
            session.close();
            factory.close();
        }
    }
}
