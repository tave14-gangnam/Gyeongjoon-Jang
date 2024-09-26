package com.tave.gangnam.week2.assignment.dto;

import com.tave.gangnam.week2.assignment.Entity.Movies;

public class MoviesDto {

    private Long id;

    private String title;

    private String genre;

    // DTO를 Entity로 변환
    public Movies toEntity() {
        return new Movies( id, title, genre);
    }

    // 기본 생성자 -> 외부에서 객체 생성 가능
    public MoviesDto() {}

    // Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
