package com.example.advancedMapping.dao;

import com.example.advancedMapping.entity.Course;
import com.example.advancedMapping.entity.Instructor;
import com.example.advancedMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor deletingInstructor = entityManager.find(Instructor.class,id);

        List<Course> courses = deletingInstructor.getCourses();

        for(Course course : courses){
            course.setInstructor(null);
        }

        entityManager.remove(deletingInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        return entityManager.find(InstructorDetail.class , id);

    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class , id);

        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = : data" , Course.class);
        query.setParameter("data",id);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> query=entityManager.createQuery(
                          "select i from Instructor i " +
                             "JOIN FETCH i.courses " +
                             "where i.id= :data" , Instructor.class
        );

        query.setParameter("data" , id);

        Instructor instructor = query.getSingleResult();

        return instructor;

    }


    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);

    }
}
