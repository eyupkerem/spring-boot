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
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    @ToString.Exclude
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor" ,
            cascade = {CascadeType.DETACH , CascadeType.MERGE ,
            CascadeType.PERSIST ,CascadeType.REFRESH})
    @ToString.Exclude
    private List<Course> courses ;

    public void add(Course tempCourse){

        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(tempCourse);

        tempCourse.setInstructor(this);
    }



    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
