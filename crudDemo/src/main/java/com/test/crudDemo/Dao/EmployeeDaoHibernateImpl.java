package com.test.crudDemo.Dao;

import com.test.crudDemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{

    //define field
    private EntityManager entityManager;

    //set up constructor
    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = currentSession.createQuery("from Employee" , Employee.class);

        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee = currentSession.get(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        //post/put in one
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }
}
