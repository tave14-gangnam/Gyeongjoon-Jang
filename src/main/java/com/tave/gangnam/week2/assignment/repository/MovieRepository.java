package com.tave.gangnam.week2.assignment.repository;

import com.tave.gangnam.week2.assignment.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByTitle(String title);

    List<Movie> findByTitleContaining(String title);

    boolean existsByTitle(String title);
}
