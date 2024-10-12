package com.tave.gangnam.week3.assigment.repository;

import com.tave.gangnam.week3.assigment.domain.Bank;
import com.tave.gangnam.week3.assigment.domain.Customer;
import com.tave.gangnam.week3.assigment.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByLoanNameAndBankAndCustomer(String loanName, Bank bank, Customer customer);
}