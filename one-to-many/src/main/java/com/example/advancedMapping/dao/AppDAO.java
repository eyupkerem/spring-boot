package com.example.advancedMapping.dao;

import com.example.advancedMapping.entity.Instructor;
import com.example.advancedMapping.entity.InstructorDetail;

public interface AppDAO {

    void save (Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

}
