package com.example.projectapp.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer year;

    @Column
    private String house;

    public Student() {
    }

    public Student(Long id, String name, Integer year, String house) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.house = house;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", house='" + house + '\'' +
                '}';
    }
}
