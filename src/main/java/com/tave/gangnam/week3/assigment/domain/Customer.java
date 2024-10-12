package com.tave.gangnam.week3.assigment.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false, unique = true)
    private String customerName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Bank> banks = new ArrayList<>();
}
