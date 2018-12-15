package com.track.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;



@Entity
public class Steps {



    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int steps_id;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;


    private int steps;



    @OneToOne
    @JoinColumn(name="username")
    private User name;

    public Steps(Date date, int steps, User name) {
        this.date = date;
        this.steps = steps;
        this.name = name;
    }

    public Steps() {
    }


    public int getSteps_id() {
        return steps_id;
    }

    public void setSteps_id(int steps_id) {
        this.steps_id = steps_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }
}
