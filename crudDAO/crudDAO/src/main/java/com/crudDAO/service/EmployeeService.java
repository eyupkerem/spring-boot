package com.crudDAO.service;

import com.crudDAO.dao.EmployeeDAO;
import com.crudDAO.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
