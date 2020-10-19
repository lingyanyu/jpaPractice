package com.practice;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name ="course_id")
    @GenericGenerator(strategy = "increment", name = "incr")
    @GeneratedValue(generator = "incr")
    Integer course_id;

    @Column(name = "course_name")
    String course_name;

    @ManyToMany(mappedBy = "courses")
    Collection<Student> studentCollection = new ArrayList<>();


    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }
}
