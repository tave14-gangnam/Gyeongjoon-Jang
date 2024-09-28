package com.tave.gangnam.week2.assignment.domain;

import com.tave.gangnam.week2.assignment.dto.MovieRequestDTO;
import com.tave.gangnam.week2.assignment.dto.MovieResponseDTO;

public class MovieMapper {
    // DTO -> Entity 변환
    public static Movie toEntity(MovieRequestDTO requestDTO) {
        return Movie.builder()
                .title(requestDTO.getTitle())
                .genre(requestDTO.getGenre())
                .director(requestDTO.getDirector())
                .year(requestDTO.getYear())
                .build();
    }

    // Entity -> DTO 변환
    public static MovieResponseDTO toDTO(Movie movie) {
        return MovieResponseDTO.builder()
                .title(movie.getTitle())
                .director(movie.getDirector())
                .genre(movie.getGenre())
                .year(movie.getYear())
                .build();
    }
}
