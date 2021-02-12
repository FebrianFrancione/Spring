//package EagerLazy;
//
//
//import EagerLazy.demo.hibernate.demo.entity.Course;
//import EagerLazy.demo.hibernate.demo.entity.Instructor;
//import EagerLazy.demo.hibernate.demo.entity.InstructorDetail;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class CreateCoursesDemo {
//    public static void main(String[] args) {
//        //create session factory
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
//
//        //craet session
//        Session session = factory.getCurrentSession();
//
//        try{
//
//
//
//            //start transaction
//            session.beginTransaction();
//
//
//            int theId = 1;
//            Instructor tempInstuctor = session.get(Instructor.class, theId);
//
//            Course tempCourse1 = new Course("Air guitar");
//            Course tempCourse2 = new Course("hand guitar");
//
//
//            tempInstuctor.add(tempCourse1);
//            tempInstuctor.add(tempCourse2);
//
//            //save
//            session.save(tempCourse1);
//            session.save(tempCourse2);
//
//            //commit trasnaction
//            session.getTransaction().commit();
//            System.out.println("done!");
//        }finally {
//
//            //add clean up code
//            session.close();
//            factory.close();
//        }
//    }
//}
