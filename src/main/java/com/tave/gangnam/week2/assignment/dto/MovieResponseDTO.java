package com.tave.gangnam.week2.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MovieResponseDTO {
    private String title;
    private String director;
    private String year;
    private String genre;

}
