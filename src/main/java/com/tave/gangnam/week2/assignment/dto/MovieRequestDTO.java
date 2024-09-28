package com.tave.gangnam.week2.assignment.dto;

import com.tave.gangnam.week2.assignment.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MovieRequestDTO {
    private String title;
    private String genre;
    private String director;
    private String year;
}
