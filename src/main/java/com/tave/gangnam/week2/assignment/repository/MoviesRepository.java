package com.tave.gangnam.week2.assignment.repository;

import com.tave.gangnam.week2.assignment.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
}
