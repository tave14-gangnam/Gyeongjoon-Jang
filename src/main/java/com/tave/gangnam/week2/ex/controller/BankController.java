package com.tave.gangnam.week2.ex.controller;

import com.tave.gangnam.week2.ex.dto.BankRequestDTO;
import com.tave.gangnam.week2.ex.dto.BankResponseDTO;
import com.tave.gangnam.week2.ex.repository.BankRepository;
import com.tave.gangnam.week2.ex.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;
    private final BankRepository bankRepository;
    public BankController(BankService bankService, BankRepository bankRepository) {
        this.bankService = bankService;
        this.bankRepository = bankRepository;
    }

    // 가입은행 종류 API
//    @GetMapping("/category/{id}")
//    public ResponseDTO getCategory( Long id) {
//
//
//    }

    // 대출 적금 API


    // 유저 등록 API
    @PostMapping("/register")
    public ResponseEntity<BankResponseDTO> registerUser(@RequestBody BankRequestDTO requestDto) {
        log.info("시작합니다." + requestDto.getId() + requestDto.getLoan() + requestDto.getInstallmentSavings() + requestDto.getBankName() + requestDto.getBankUser());
        BankResponseDTO responseDTO = bankService.createBank(requestDto);
        return ResponseEntity.ok(responseDTO);
    }

    // 유저 조회 API
//    @GetMapping("/read/{id}")
//    public ResponseEntity<ResponseDTO> readUser(@PathVariable Long id) {
//
//    }

}
