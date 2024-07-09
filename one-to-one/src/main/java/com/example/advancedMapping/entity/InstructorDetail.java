package com.example.advancedMapping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtubeChannel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    // Allow all cascade operations
    //@OneToOne(mappedBy ="instructorDetail" , cascade = CascadeType.ALL)

    // Allow cascade operations without remove
    @OneToOne(mappedBy = "instructorDetail" , cascade = {CascadeType.DETACH ,CascadeType.MERGE , CascadeType.PERSIST})
    @ToString.Exclude
    private Instructor instructor;




    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
