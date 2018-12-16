package com.track.entity;

import javax.persistence.*;


@Entity
public class Student {


    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @OneToOne
    @JoinColumn(name="username")
    private User name;




    public Student(int id, User name, String password) {
        this.id = id;
        this.name = name;

    }

    public Student() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
