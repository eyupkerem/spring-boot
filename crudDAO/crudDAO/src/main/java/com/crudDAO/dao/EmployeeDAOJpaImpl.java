package com.crudDAO.dao;

import com.crudDAO.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> findAllQuery = entityManager.createQuery("from Employee ",Employee.class);

        List<Employee> employees = findAllQuery.getResultList();

        return employees;
    }


    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee newEmployee = entityManager.merge(employee);

        return newEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class,id);

        entityManager.remove(employee);
    }
}
