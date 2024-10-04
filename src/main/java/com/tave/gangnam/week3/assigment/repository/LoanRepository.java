package com.tave.gangnam.week3.assigment.repository;

import com.tave.gangnam.week3.assigment.domain.Bank;
import com.tave.gangnam.week3.assigment.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByLoanNameAndBank(String loanName, Bank bank);
    List<Loan> findByBankOrderByLoanIdAsc(Bank bank);
}