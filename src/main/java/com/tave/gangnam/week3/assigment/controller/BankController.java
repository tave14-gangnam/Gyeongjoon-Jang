package com.tave.gangnam.week3.assigment.controller;

import com.tave.gangnam.week3.assigment.dto.BankRequestDto;
import com.tave.gangnam.week3.assigment.dto.BankResponseDto;
import com.tave.gangnam.week3.assigment.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<String> createBank(@PathVariable Long customerId,
                                             @RequestBody BankRequestDto bankRequestDto) {
        log.info("Controller: 은행 등록 시작!");
        ResponseEntity<String> response = bankService.createBank(customerId, bankRequestDto);
        log.info("Controller: 은행 등록 메시지 반환!");
        return response;
    }

    // 은행 조회
    @GetMapping("/{bankId}")
    public ResponseEntity<BankResponseDto> showBank(@PathVariable Long customerId,
                                                    @PathVariable Long bankId) {
        log.info("Controller: 은행 조회 시작!");
        ResponseEntity<BankResponseDto> bankResponseDto = bankService.showBank(customerId, bankId);
        log.info("Controller: 은행 조회 메시지 반환!");
        return bankResponseDto;
    }
}
