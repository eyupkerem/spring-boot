package com.cruddemo.dao;

import com.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("From Student ",Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("From Student Where lastName=:theData",Student.class);

        query.setParameter("theData",lastName);

         return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

     @Override
    @Transactional
    public void delete(Integer id) {
        Student deletingStudent = entityManager.find(Student.class , id);

        entityManager.remove(deletingStudent);
    }
}
