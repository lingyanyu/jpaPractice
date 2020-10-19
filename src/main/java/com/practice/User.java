package com.practice;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {


        @Id
        @Column(name = "user_id")
        @GenericGenerator(strategy = "increment", name = "incr")
        @GeneratedValue(generator = "incr")
        Integer user_id;

        @Column(name = "user_name")
        String user_name;

        @OneToMany(mappedBy = "user")
        Collection<Laptop> laptops = new ArrayList<>();

    public Collection<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Collection<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Integer getUser_id() {
            return user_id;
        }

        public void setUser_id(Integer user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

}
