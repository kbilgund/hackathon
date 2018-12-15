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


    @ManyToOne
    @JoinColumn(name="id")
    private Student student;



    public Steps() {
    }

    public Steps(int id, Date date, int steps, Student student) {
        this.steps_id = id;
        this.date = date;
        this.steps = steps;
        this.student = student;
    }


    public int getId() {
        return steps_id;
    }

    public void setId(int id) {
        this.steps_id = id;
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

    @Override
    public String toString() {
        return "Steps{" +
                "id=" + steps_id +
                ", date=" + date +
                ", steps=" + steps +
                ", student=" + student +
                '}';
    }
}
