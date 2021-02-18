package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers(int theSortField);

    void saveCustomer(Customer theCustomer);

   public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

    public List<Customer> searchCustomers(String theSearchName);
}
