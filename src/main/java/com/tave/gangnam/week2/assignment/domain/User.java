package com.tave.gangnam.week2.assignment.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int age;
}
