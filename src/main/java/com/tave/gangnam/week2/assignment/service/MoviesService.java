package com.tave.gangnam.week2.assignment.service;

import com.tave.gangnam.week2.assignment.Entity.Movies;
import com.tave.gangnam.week2.assignment.dto.MoviesDto;
import com.tave.gangnam.week2.assignment.repository.MoviesRepository;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {

    // MoviesRepository 필드 선언
    private final MoviesRepository movieRepository;

    // 의존성 주입 통해 MoviesRepository를 주입 -> Service 내에서 Repository 사용 가능
    public MoviesService(MoviesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 조회
    public Movies show(Long id) { return movieRepository.findById(id).orElse(null); }

    // 저장
    public Movies create(MoviesDto dto) {
        Movies movies = dto.toEntity();
        if (movies.getId() != null) {
            return null;
        }
        return movieRepository.save(movies);
    }
}
