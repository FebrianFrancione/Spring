package com.luv2code.springdemo;


import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //inject customer service
    @Autowired
    private CustomerService customerService;

//    @GetMapping("/list")
//    public String listCustomers(Model theModel){
//
//
//        //get customers from service
//        List<Customer> theCustomers = customerService.getCustomers();
//
//        theModel.addAttribute("customers", theCustomers);
//        return "list-customers";
//    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){

        //get customer

        Customer theCustomer = customerService.getCustomer(theId);
        //set customer as model attribute

        theModel.addAttribute("customer", theCustomer);
        //send over the form

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {

        // get customers from the service
        List<Customer> theCustomers = null;

        // check for sort field
        if (sort != null) {
            int theSortField = Integer.parseInt(sort);
            theCustomers = customerService.getCustomers(theSortField);
        }
        else {
            // no sort field provided ... default to sorting by last name
            theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
        }

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}

