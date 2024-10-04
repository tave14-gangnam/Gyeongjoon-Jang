package com.tave.gangnam.week3.assigment.service;

import com.tave.gangnam.week3.assigment.domain.BankMapper;
import com.tave.gangnam.week3.assigment.domain.Bank;
import com.tave.gangnam.week3.assigment.domain.Customer;
import com.tave.gangnam.week3.assigment.dto.BankRequestDto;
import com.tave.gangnam.week3.assigment.dto.BankResponseDto;
import com.tave.gangnam.week3.assigment.exception.BankAlreadyExistsException;
import com.tave.gangnam.week3.assigment.exception.BankNotFoundException;
import com.tave.gangnam.week3.assigment.exception.CustomerNotFoundException;
import com.tave.gangnam.week3.assigment.repository.BankRepository;
import com.tave.gangnam.week3.assigment.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankService {

    private  final CustomerRepository customerRepository;
    private final BankRepository bankRepository;

    // 은행 등록 API
    @Transactional
    public ResponseEntity<String> createBank(Long customerId, BankRequestDto bankRequestDto) {
        log.info("service: 은행 등록 API 시작!");

        log.info("service: 기존회원인지 확인 시작");
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("사용자 ID: " + customerId + "이(가) 존재하지 않습니다."));
        log.info("service: 기존회원 입니다");

        log.info("service: 기존은행인지 확인 시작");
        bankRepository.findByBankNameAndCustomer(bankRequestDto.getBankName(), customer)
                .ifPresent(bank -> {
                    log.info("service: 기존은행 입니다");
                    throw new BankAlreadyExistsException(bankRequestDto.getBankName() + "님이 이미 존재합니다.");
                });
        log.info("service: 기존은행 아닙니다");

        log.info("service: 새로운 은행 객체 생성");
        Bank newBank = BankMapper.toBankEntity(bankRequestDto, customer);
        newBank.setCustomer(customer);

        log.info("service: DB 저장");
        bankRepository.save(newBank);

        log.info("service: 메시지 반환!");
        return ResponseEntity.ok(newBank.getBankName() + "이 등록되었습니다.");
    }

    // 은행 조회 API
    @Transactional(readOnly = true)
    public BankResponseDto showBank(Long customerId, Integer bankOrder) {
        log.info("service: 은행 조회 API 시작!");

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("사용자 ID: " + customerId + "이(가) 존재하지 않습니다."));

        List<Bank> customerBanks = bankRepository.findByCustomerOrderByBankIdAsc(customer);

        if (bankOrder < 1 || bankOrder > customerBanks.size()) {
            throw new BankNotFoundException("사용자의 " + bankOrder + "번째 은행이 존재하지 않습니다.");
        }

        Bank bank = customerBanks.get(bankOrder - 1);

        return BankMapper.toBankDto(bank, customer);
    }
}

