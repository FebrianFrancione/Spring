import com.demo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("src/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //craet session
        Session session = factory.getCurrentSession();

        try{

            int studentId = 1;

            //get sessions new and start transaction.
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating Student...");
            myStudent.setFirstName("test");

            //commit thetransaction
            session.getTransaction().commit();

            //new code
            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Update email for all students");

            session.createQuery("update com.demo.hibernate.demo.entity.Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("done!");
        }finally {
            factory.close();
        }
    }
}
