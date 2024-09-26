package com.tave.gangnam.week2.assignment.Entity;

import jakarta.persistence.*;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long id;

    private String title;

    private String genre;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;

    // 기본 생성자 -> 외부에서 객체 생성 가능
    public Movies() {}

    // 생성자 -> toEntity할때 사용
    public Movies(Long id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
