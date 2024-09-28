package com.tave.gangnam.week2.assignment.controller;

import com.tave.gangnam.week2.assignment.domain.MovieMapper;
import com.tave.gangnam.week2.assignment.dto.MovieRequestDTO;
import com.tave.gangnam.week2.assignment.dto.MovieResponseDTO;
import com.tave.gangnam.week2.assignment.domain.Movie;
import com.tave.gangnam.week2.assignment.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // 영화 등록 API
    @PostMapping("/create")
    public ResponseEntity<MovieResponseDTO> createMovie(
            @RequestBody MovieRequestDTO requestDto
            ) {
        MovieResponseDTO responseDTO = movieService.saveMovie(requestDto);
        return ResponseEntity.ok(responseDTO);
    }

    // 영화 조회 API
    @GetMapping("/read/{id}")
    public Optional<Movie> getMovie(@PathVariable Long id) {
        return movieService.findMovie(id);
    }

    // 제목으로 영화 조회
    @GetMapping("/read")
    public List<Movie> getMoviesByTitle(String title) {
        return movieService.findMoviesByTitle(title);
    }
}
