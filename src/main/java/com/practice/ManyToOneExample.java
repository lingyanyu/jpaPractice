package com.practice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneExample {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("firstHib");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Laptop l1 = new Laptop();
        l1.setCapacity(30);
        Laptop l2 = new Laptop();
        l2.setCapacity(40);

        User user = new User();
        user.setUser_name("Lucy");

        l1.setUser(user);
        l2.setUser(user);
        user.getLaptops().add(l1);
        user.getLaptops().add(l2);

        entityManager.getTransaction().begin();

        entityManager.persist(user);
        entityManager.persist(l1);
        entityManager.persist(l2);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
