package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyExample {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("firstHib");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        //Many to Many Example with Student and Course
        Student s1 = new Student();
        s1.setStudentName("LiLei");
        Student s2 = new Student();
        s2.setStudentName("HanMeiMei");

        Course c1 = new Course();
        c1.setCourse_name("Math");

        Course c2 = new Course();
        c2.setCourse_name("Biology");

        s1.getCourses().add(c1);
        s1.getCourses().add(c2);
        s2.getCourses().add(c1);
        c1.getStudentCollection().add(s1);
        c1.getStudentCollection().add(s2);
        c2.getStudentCollection().add(s1);

        entityManager.getTransaction().begin();
        entityManager.persist(s1);
        entityManager.persist(s2);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        
    }
}
