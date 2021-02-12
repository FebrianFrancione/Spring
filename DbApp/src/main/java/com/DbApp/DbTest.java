package com.DbApp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


@WebServlet(name = "DbTest", value = "/DbTest")
public class DbTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        //jdbc:mysql://127.0.0.1:3306/web_customer_tracker?useSSL=false
//           String jdbUrl = "jdbc:mysql://127.0.0.1:3306/hb-01-one-to-one-uni?useSSL=false";
        String jdbUrl = "jdbc:mysql://127.0.0.1:3306/web_customer_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try{
//                System.out.println("Connecting to DB - from hbOneToOne: " + jdbUrl);
//
//                Connection conn = DriverManager.getConnection(jdbUrl, user, pass);
//                System.out.println("Connection Successful!");

            PrintWriter out = response.getWriter();

            out.println("Connecting to database: " + jdbUrl);

            Class.forName("com.mysql.jdbc.Driver");

            out.println("Reached");
            Connection myConn = DriverManager.getConnection(jdbUrl, user, pass);

            out.println("SUCCESS");

            myConn.close();

        }catch (Exception exc){
            exc.printStackTrace();
            throw new ServletException(exc);
        }

    }

}
