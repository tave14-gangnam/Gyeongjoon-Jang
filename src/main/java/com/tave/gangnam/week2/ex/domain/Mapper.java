package com.tave.gangnam.week2.ex.domain;

import com.tave.gangnam.week2.ex.dto.BankRequestDTO;
import com.tave.gangnam.week2.ex.dto.BankResponseDTO;

public class Mapper {
    // DTO -> Entity 변환
    public static Bank toEntity(BankRequestDTO requestDTO) {
        return Bank.builder()
                .bankName(requestDTO.getBankName())
                .bankUser(requestDTO.getBankUser())
                .installmentSavings(requestDTO.getInstallmentSavings())
                .loan(requestDTO.getLoan())
                .build();

    }

    // Entity -> DTO 변환
    public static BankResponseDTO toDTO(Bank bank) {
        return BankResponseDTO.builder()
                .bankName(bank.getBankName())
                .build();
    }
}
