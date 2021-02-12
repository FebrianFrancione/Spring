package hbOneToManyUni.src.OneToMany.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc3 {
    public static void main(String[] args) {
        String jdbUrl = "jdbc:mysql://127.0.0.1:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
            System.out.println("Connecting to DB - from hbOneToOne: " + jdbUrl);

            Connection conn = DriverManager.getConnection(jdbUrl, user, pass);
            System.out.println("Connection Successful!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
