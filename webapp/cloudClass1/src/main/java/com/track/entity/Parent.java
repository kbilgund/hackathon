package com.track.entity;

import javax.persistence.*;


@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public Parent(int id, User name, int phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name="username")
    private User name;


    int phone_number;

    public Parent() {
    }

    public Parent(int id, int phone_number) {
        this.id = id;
        this.phone_number = phone_number;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", name=" + name +
                ", phone_number=" + phone_number +
                '}';
    }
}
