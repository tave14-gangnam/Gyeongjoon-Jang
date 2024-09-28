package com.tave.gangnam.week2.ex.service;

import com.tave.gangnam.week2.ex.domain.Bank;
import com.tave.gangnam.week2.ex.domain.Mapper;
import com.tave.gangnam.week2.ex.dto.BankRequestDTO;
import com.tave.gangnam.week2.ex.dto.BankResponseDTO;
import com.tave.gangnam.week2.ex.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    // 가입은행 종류 API
    @Transactional(readOnly = true)
    public BankResponseDTO searchBank(Long id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없습니다."));
        return Mapper.toDTO(bank);
    }

    // 대출 적금 API


    // 유저 등록 API
    @Transactional
    public BankResponseDTO createBank(BankRequestDTO requestDTO) {
        Bank bank = bankRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("없습니다."));
        log.info("bank user 확인합니다." + bank);
        Bank savedBank = bankRepository.save(bank);
        return Mapper.toDTO(savedBank);
    }


    // 유저 조회 API


}
