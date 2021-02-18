//package com.luv2code.testdb;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
//public class TestDbServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user = "springstudent";
//        String pass = "springstudent";
//
//        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
//        String driver = "com.mysql.jdbc.Driver";
//
//        try{
//            PrintWriter out = response.getWriter();
//            out.println("Connecting to db: " + jdbcUrl);
//            Class.forName(driver);
//
//            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
//
//            out.println("Success!");
//            myConn.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//}
