package com.tave.gangnam.week3.assigment.controller;

import com.tave.gangnam.week3.assigment.dto.LoanRequestDto;
import com.tave.gangnam.week3.assigment.dto.LoanResponseDto;
import com.tave.gangnam.week3.assigment.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/week3/{customerId}/bank/{bankId}/loan")
public class LoanController {

    private final LoanService loanService;

    // 대출 등록
    @PostMapping
    public ResponseEntity<String> createLoan(@PathVariable Long customerId,
                                             @PathVariable Long bankId,
                                             @RequestBody LoanRequestDto loanRequestDto) {
        ResponseEntity<String> response = loanService.createLoan(loanRequestDto, bankId, customerId);
        return response;
    }

    // 대출 조회
    @GetMapping("/{loanId}")
    public ResponseEntity<LoanResponseDto> showLoan(@PathVariable Long customerId,
                                                    @PathVariable Long bankId,
                                                    @PathVariable Long loanId) {
        ResponseEntity<LoanResponseDto> response = loanService.showLoan(customerId, bankId, loanId);
        return response;
    }
}
