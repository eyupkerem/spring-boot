package com.crudDAO.dao;

import com.crudDAO.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
