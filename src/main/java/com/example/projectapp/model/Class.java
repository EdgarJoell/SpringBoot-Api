package com.example.projectapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public Class() {
    }
}
