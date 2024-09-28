package com.tave.gangnam.week2.ex.repository;

import com.tave.gangnam.week2.ex.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
