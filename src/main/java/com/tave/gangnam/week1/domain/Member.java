package com.tave.gangnam.week1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor // Constructor
@Builder
@NoArgsConstructor // 기본 생성자
public class Member {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // AllArgsConstructor
//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    // 생성자: TODO 생성자를 만드는 이유
//    public Member() {}

    //
}
