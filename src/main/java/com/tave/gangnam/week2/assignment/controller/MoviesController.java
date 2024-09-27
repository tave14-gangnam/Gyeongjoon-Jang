package com.tave.gangnam.week2.assignment.controller;

import com.tave.gangnam.week2.assignment.Entity.Movies;
import com.tave.gangnam.week2.assignment.dto.MoviesDto;
import com.tave.gangnam.week2.assignment.service.MoviesService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoviesController {

    //MoviesService 필드 선언
    private final MoviesService moviesService;

    // 의존성 주입 통해 MoviesService를 주입 -> Controller 내에서 Service 사용 가능
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    // 조회
    @GetMapping("/movies/{id}")
    public Movies show(@PathVariable Long id) { return moviesService.show(id); }

    // 저장
    @PostMapping("/movies")
    public Movies create(@RequestBody MoviesDto dto) { return moviesService.create(dto); }
}
