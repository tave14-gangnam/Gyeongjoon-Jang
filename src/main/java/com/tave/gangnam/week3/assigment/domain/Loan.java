package com.tave.gangnam.week3.assigment.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String loanName;

    private double loanAmount;

    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankId")
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;
}
