package com.tave.gangnam.week3.assigment.controller;

import com.tave.gangnam.week3.assigment.dto.CustomerRequestDto;
import com.tave.gangnam.week3.assigment.dto.CustomerResponseDto;
import com.tave.gangnam.week3.assigment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/week3")
public class CustomerController {

    private final CustomerService customerService;


    // 유저 등록
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        log.info("Controller: 유저 등록 시작!");
        ResponseEntity<String> response = customerService.createCustomer(customerRequestDto);
        log.info("Controller: 유저 등록 메시지 출력!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
    }


    // 유저 조회
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> showCustomer(@PathVariable Long customerId) {
        log.info("Controller: 유저 조회 시작!");
        CustomerResponseDto customerResponseDto = customerService.showCustomer(customerId);
        log.info("Controller: 유저 조회 메시지 출력!");
        return ResponseEntity.ok(customerResponseDto);
    }
}
