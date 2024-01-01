package com.example.springproject;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "student name")
    private String name;

    @Column(name = "Age")
    private int age;

}
