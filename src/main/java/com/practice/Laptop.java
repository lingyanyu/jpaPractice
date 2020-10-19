package com.practice;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @Column(name = "laptop_id")
    @GenericGenerator(strategy = "increment", name = "incr")
    @GeneratedValue(generator = "incr")
    Integer laptop_id;


    @Column(name = "capacity")
    Integer capacity;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;

    public Integer getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(Integer laptop_id) {
        this.laptop_id = laptop_id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
