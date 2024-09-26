package com.tave.gangnam.week2.assignment.repository;

import com.tave.gangnam.week2.assignment.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
