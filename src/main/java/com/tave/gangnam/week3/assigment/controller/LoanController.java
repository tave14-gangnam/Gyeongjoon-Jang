package com.tave.gangnam.week3.assigment.controller;

import com.tave.gangnam.week3.assigment.dto.LoanRequestDto;
import com.tave.gangnam.week3.assigment.dto.LoanResponseDto;
import com.tave.gangnam.week3.assigment.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/week3/{customerId}/bank/{bankOrder}/loan")
public class LoanController {

    private final LoanService loanService;

    // 대출 등록
    @PostMapping
    public ResponseEntity<String> createLoan(@PathVariable Long customerId, @PathVariable Integer bankOrder, @RequestBody LoanRequestDto loanRequestDto) {
        ResponseEntity<String> response = loanService.createLoan(loanRequestDto, bankOrder, customerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
    }

    // 대출 조회
    @GetMapping("/{loanOrder}")
    public ResponseEntity<LoanResponseDto> showLoan(@PathVariable Long customerId, @PathVariable Integer bankOrder, @PathVariable Integer loanOrder) {
        LoanResponseDto response = loanService.showLoan(customerId, bankOrder, loanOrder);
        return ResponseEntity.ok(response);
    }
}
