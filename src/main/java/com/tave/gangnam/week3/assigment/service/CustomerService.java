package com.tave.gangnam.week3.assigment.service;

import com.tave.gangnam.week3.assigment.domain.CustomerMapper;
import com.tave.gangnam.week3.assigment.domain.Customer;
import com.tave.gangnam.week3.assigment.dto.CustomerRequestDto;
import com.tave.gangnam.week3.assigment.dto.CustomerResponseDto;
import com.tave.gangnam.week3.assigment.exception.CustomerAlreadyExistsException;
import com.tave.gangnam.week3.assigment.exception.CustomerNotFoundException;
import com.tave.gangnam.week3.assigment.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 유저 등록 API
    @Transactional
    public ResponseEntity<String> createCustomer(CustomerRequestDto customerRequestDto) {
        log.info("service: 유저 등록 API 시작!");

        log.info("service: 기존회원인지 확인 시작");
        customerRepository.findByCustomerName(customerRequestDto.getCustomerName())
                    .ifPresent(customer -> {
                        log.info("service: 기존회원 입니다");
                        throw new CustomerAlreadyExistsException("사용자: " + customerRequestDto.getCustomerName() + "님이 이미 존재합니다.");
                    });
        log.info("service: 기존회원 아닙니다");

        log.info("service: 새로운 회원 객체 생성");
        Customer newCustomer = CustomerMapper.toEntity(customerRequestDto);

        log.info("service: DB 저장");
        customerRepository.save(newCustomer);

        log.info("service: 메시지 반환!");
        return ResponseEntity.ok("손님 " + newCustomer.getCustomerName() + "님이 등록되었습니다.");
    }

    // 유저 조회 API
    @Transactional(readOnly = true)
    public CustomerResponseDto showCustomer(Long customerId) {
        log.info("service: 유저 조회 API 시작!");

        log.info("service: 기존회원인지 확인 시작");
        Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> {
                        throw new CustomerNotFoundException("사용자 ID: " + customerId + "이(가) 존재하지 않습니다.");
                    });
        log.info("service: 기존회원 입니다");

        log.info("service: 객체를 DTO로 반환");
        return CustomerMapper.toDto(customer);
    }
}
