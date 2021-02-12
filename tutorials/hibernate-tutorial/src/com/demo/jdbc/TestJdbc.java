import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("Connecting to DB" + jdbUrl);

            Connection conn = DriverManager.getConnection(jdbUrl, user, pass);
            System.out.println("Connection Successful!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
