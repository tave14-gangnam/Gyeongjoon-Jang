package com.tave.gangnam.week3.assigment.controller;

import com.tave.gangnam.week3.assigment.dto.BankRequestDto;
import com.tave.gangnam.week3.assigment.dto.BankResponseDto;
import com.tave.gangnam.week3.assigment.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/week3/{customerId}/bank")
public class BankController {

    private final BankService bankService;

    // 은행 등록
    @PostMapping
    public ResponseEntity<String> createBank(@PathVariable Long customerId, @RequestBody BankRequestDto bankRequestDto) {
        log.info("Controller: 은행 등록 시작!");
        ResponseEntity<String> response = bankService.createBank(customerId, bankRequestDto);
        log.info("Controller: 은행 등록 메시지 반환!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
    }

    // 은행 조회
    @GetMapping("/{bankOrder}")
    public ResponseEntity<BankResponseDto> showBank(@PathVariable Long customerId, @PathVariable Integer bankOrder) {
        log.info("Controller: 은행 조회 시작!");
        BankResponseDto bankResponseDto = bankService.showBank(customerId, bankOrder);
        log.info("Controller: 은행 조회 메시지 반환!");
        return ResponseEntity.ok(bankResponseDto);
    }
}
