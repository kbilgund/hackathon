package com.track.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Student {



    @Id
    @Column(nullable=false)
    private int id;


    private String name;



    public Student(int id, String name, String password) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
