package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers(int theSortField) {
        return customerDao.getCustomers(theSortField);
    }

//    @Override
//    public List<Customer> getCustomers(int theSortField) {
//        return null;
//    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDao.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDao.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {

        customerDao.deleteCustomer(theId);

    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {
        return customerDao.searchCustomers(theSearchName);
    }
}
