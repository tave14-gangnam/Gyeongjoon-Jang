package com.tave.gangnam.week2.assignment.dto;

import com.tave.gangnam.week2.assignment.Entity.Users;

public class UsersDto {

    private Long id;

    private String name;

    private int age;

    // 기본 생성자 -> 외부에서 객체 생성 가능
    public UsersDto() {}

    // DTO를 Entity로 변환
    public Users toEntity() {
        return new Users(id, name, age);
    }

    // Getter, Setter
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
