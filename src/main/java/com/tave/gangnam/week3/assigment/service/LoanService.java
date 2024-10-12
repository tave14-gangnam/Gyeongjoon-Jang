package com.tave.gangnam.week3.assigment.service;

import com.tave.gangnam.week3.assigment.domain.Bank;
import com.tave.gangnam.week3.assigment.domain.Customer;
import com.tave.gangnam.week3.assigment.domain.Loan;
import com.tave.gangnam.week3.assigment.domain.LoanMapper;
import com.tave.gangnam.week3.assigment.dto.LoanRequestDto;
import com.tave.gangnam.week3.assigment.dto.LoanResponseDto;
import com.tave.gangnam.week3.assigment.exception.BankNotFoundException;
import com.tave.gangnam.week3.assigment.exception.CustomerNotFoundException;
import com.tave.gangnam.week3.assigment.exception.LoanAlreadyExistsException;
import com.tave.gangnam.week3.assigment.exception.LoanNotFoundException;
import com.tave.gangnam.week3.assigment.repository.BankRepository;
import com.tave.gangnam.week3.assigment.repository.CustomerRepository;
import com.tave.gangnam.week3.assigment.repository.LoanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanService {

    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;
    private final LoanRepository loanRepository;

    // 대출 등록 API
    @Transactional
    public ResponseEntity<String> createLoan(LoanRequestDto loanRequestDto, Long bankId, Long customerId) {
        log.info("service: 대출 등록 API 시작!");

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("사용자 ID: " + customerId + "이(가) 존재하지 않습니다."));

        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new BankNotFoundException("은행 ID: " + bankId + "가 존재하지 않습니다."));

        loanRepository.findByLoanNameAndBankAndCustomer(loanRequestDto.getLoanName(), bank, customer)
                .ifPresent(loan -> {
                    throw new LoanAlreadyExistsException(loanRequestDto.getLoanName() + "이 이미 존재합니다.");
                });

        Loan newLoan = LoanMapper.toLoanEntity(loanRequestDto, bank);
        newLoan.setCustomer(customer);

        loanRepository.save(newLoan);

        log.info("service: 대출 등록 완료!");
        return ResponseEntity.status(HttpStatus.CREATED).body(newLoan.getLoanName() + "이 등록되었습니다.");
    }

    // 대출 조회 API
    @Transactional(readOnly = true)
    public ResponseEntity<LoanResponseDto> showLoan(Long customerId, Long bankId, Long loanId) {
        log.info("service: 대출 조회 API 시작!");

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("사용자 ID: " + customerId + "이(가) 존재하지 않습니다."));

        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new BankNotFoundException("은행 ID: " + bankId + "가 존재하지 않습니다."));

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new BankNotFoundException("대출 ID: " + loanId + "가 존재하지 않습니다."));

        LoanResponseDto responseDto = LoanMapper.toLoanDto(loan, bank);

//        if (loan.getLoanAmount() >= 1000) {
//            responseDto.setColor("빨간색");
//        } else {
//            responseDto.setColor("노란색");
//        }
//
//        log.info("service: 대출 조회 완료!");

        return ResponseEntity.status(HttpStatus.FOUND).body(responseDto);
    }
}