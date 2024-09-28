package com.tave.gangnam.week2.assignment.service;

import com.tave.gangnam.week2.assignment.domain.Movie;
import com.tave.gangnam.week2.assignment.domain.MovieMapper;
import com.tave.gangnam.week2.assignment.dto.MovieRequestDTO;
import com.tave.gangnam.week2.assignment.dto.MovieResponseDTO;
import com.tave.gangnam.week2.assignment.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 영화 등록하기
    @Transactional
    public MovieResponseDTO saveMovie(MovieRequestDTO requestDto){

//        try {
//            if (movieRepository.existsByTitle(requestDto.getTitle())) {
//                // 중복된 영화 제목이 있을 때 예외 발생
//                throw new IllegalArgumentException("중복된 영화 제목이 있습니다: " + requestDto.getTitle());
//            } else {
//                // 중복이 아닐 경우, 새로운 영화를 추가하는 로직
//                Movie newMovie = new Movie();
//                newMovie.setTitle(requestDto.getTitle());
//                // 다른 속성들도 설정
//                movieRepository.save(newMovie);
//            }
//        } catch (DuplicateTitleException e) {
//        Movie movie = movieRepository.findByTitle(requestDto.getTitle())
//                .orElseThrow(() -> new IllegalArgumentException(""));
        Movie savedMovie = movieRepository.save(MovieMapper.toEntity(requestDto));
        return MovieMapper.toDTO(savedMovie);
    }

    // ID로 영화 검색하기
    @Transactional(readOnly = true)
    public Optional<Movie> findMovie(Long id) {
        return movieRepository.findById(id);
    }

    // 제목으로 영화 조회하기
    @Transactional(readOnly = true)
    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }
}
