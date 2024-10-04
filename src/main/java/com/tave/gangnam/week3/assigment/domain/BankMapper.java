package com.tave.gangnam.week3.assigment.domain;

import com.tave.gangnam.week3.assigment.dto.BankRequestDto;
import com.tave.gangnam.week3.assigment.dto.BankResponseDto;

public class BankMapper {

    // 은행 DTO -> Entity
    public static Bank toBankEntity(BankRequestDto bankRequestDto, Customer customer) {
        return Bank.builder()
                .bankName(bankRequestDto.getBankName())
                .installmentSavings(bankRequestDto.getInstallmentSavings())
                .customer(customer)
                .build();
    }

    // 은행 Entity -> DTO
    public static BankResponseDto toBankDto(Bank bank, Customer customer) {
        return BankResponseDto.builder()
                .bankId(bank.getBankId())
                .bankName(bank.getBankName())
                .customerName(customer.getCustomerName())
                .build();
    }
}
