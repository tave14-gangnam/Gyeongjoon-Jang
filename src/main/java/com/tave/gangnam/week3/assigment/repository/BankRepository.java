package com.tave.gangnam.week3.assigment.repository;

import com.tave.gangnam.week3.assigment.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
