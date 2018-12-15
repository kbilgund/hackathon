package com.track.entity;

import javax.persistence.*;
import java.util.Date;



public class Steps {

    private int id;

    private Date date;


    private int steps;


    private Student student;



    public Steps() {
    }

    public Steps(int id, Date date, int steps, Student student) {
        this.id = id;
        this.date = date;
        this.steps = steps;
        this.student = student;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
