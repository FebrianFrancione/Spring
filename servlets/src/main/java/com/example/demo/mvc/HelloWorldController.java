package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloWorldController {
    // need a controller method to show html form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    //need a controller method to process html
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //new controller method to read data
    //add data to model
    @RequestMapping("/processForm2")
    public String Shout(HttpServletRequest request, Model model){

        //read request param
        String theName = request.getParameter("studentName");
        //convert data to all caps
        theName = theName.toUpperCase();

        String result = "Yo! " + theName;
        //create message and add message to model
        model.addAttribute("message" , result);
        return "helloworld";
    }

}
