package com.practice;

import org.hibernate.Criteria;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryExamples {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstHib");
    public static void main(String[] args) {

        //namedQueryEx();

        //criteriaEx();

//        NPlusOneFixSolution1();

        
        NPlusOneFixSolution2();

    }

    private static void NPlusOneFixSolution1() {

        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        userRoot.fetch("laptops", JoinType.INNER);
        List<User> list = em.createQuery(cq).getResultList();
        em.close();
        emf.close();
        list.stream().forEach(u -> System.out.println(u.user_id));

    }



    private static void NPlusOneFixSolution2() {

        EntityManager em = emf.createEntityManager();
        List<User> list = em.createQuery("from User u join fetch u.laptops").getResultList();
        em.close();
        emf.close();
        list.stream().forEach(s -> System.out.println(s.user_id));
    }

    private static void criteriaEx() {
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = cq.from(Student.class);
        cq.select(studentRoot).where(criteriaBuilder.equal(studentRoot.get("studentName"),"HanMeiMei"));
        List<Student> list = em.createQuery(cq).getResultList();
        em.close();
        emf.close();
        list.stream().forEach(s -> System.out.println(s.studentId));
    }

    private static void namedQueryEx() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Student.byId");
        query.setParameter("id",2);
        List<Student> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        for(Student s : list){
            System.out.println(s.studentName);
        }
    }


}
