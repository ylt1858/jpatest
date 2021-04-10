package com.studuyjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String name;

    private boolean sex;

//    @ManyToOne(targetEntity = Teacher.class)
//    @JsonIgnore

    @ManyToOne
    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student() {
    }

    public Student(Long id, String name, boolean sex) {
        this.sno = id;
        this.name = name;
        this.sex = sex;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long id) {
        this.sno = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", sex=" + sex +
//                ", teacherId=" + teacher.getId() +
                '}';
    }
}
