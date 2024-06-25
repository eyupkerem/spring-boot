package com.cruddemo.dao;

import com.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastname(String lastName);
    void update(Student student);

}
