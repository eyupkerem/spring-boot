package com.example.advancedMapping.dao;

import com.example.advancedMapping.entity.Course;
import com.example.advancedMapping.entity.Instructor;
import com.example.advancedMapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save (Instructor instructor);

    void update (Instructor instructor);

    Instructor findById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewsByCourseId(int id);



}
