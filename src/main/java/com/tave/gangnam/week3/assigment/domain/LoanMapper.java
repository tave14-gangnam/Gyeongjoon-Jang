package com.tave.gangnam.week3.assigment.domain;

import com.tave.gangnam.week3.assigment.dto.LoanRequestDto;
import com.tave.gangnam.week3.assigment.dto.LoanResponseDto;

public class LoanMapper {

    // 대출 DTO -> Entity
    public static Loan toLoanEntity(LoanRequestDto loanRequestDto, Bank bank) {
        return Loan.builder()
                .loanName(loanRequestDto.getLoanName())
                .loanAmount(loanRequestDto.getLoanAmount())
                .bank(bank)
                .build();

    }

    // 대출 Entity -> DTO
    public static LoanResponseDto toLoanDto(Loan loan, Bank bank) {
        return LoanResponseDto.builder()
                .loanId(loan.getLoanId())
                .loanName(loan.getLoanName())
                .loanAmount(loan.getLoanAmount())
                .color(loan.getColor())
                .bankName(bank.getBankName())
                .build();
    }
}
