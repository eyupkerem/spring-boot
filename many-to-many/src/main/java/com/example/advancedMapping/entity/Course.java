package com.example.advancedMapping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE ,
                          CascadeType.PERSIST ,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    @ToString.Exclude
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.DETACH , CascadeType.MERGE ,
            CascadeType.PERSIST ,CascadeType.REFRESH} )
    @JoinTable(
            name = "course_student" ,
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
       )
    @ToString.Exclude
    private List<Student> students;

    public void addStudent(Student student){
        if (students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }


    public void addReview(Review review){

        if (reviews == null){
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }

    public Course(String title) {
        this.title = title;
    }

}
