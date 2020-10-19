package com.practice;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(name ="Student.byId", query = "from Student where studentId = :id")
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "stu_id")
    @GenericGenerator(strategy = "increment", name = "incr")
    @GeneratedValue(generator = "incr")
    Integer studentId;

    @Column(name = "stu_name")
    String studentName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
         name = "stu_course_registeration",
         joinColumns = @JoinColumn(name = "stu_id"),
         inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    Collection<Course> courses = new ArrayList<>();


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
}
