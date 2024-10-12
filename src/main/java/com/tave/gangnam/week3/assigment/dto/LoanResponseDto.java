package com.tave.gangnam.week3.assigment.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDto {

    private Long loanId;

    private String loanName;

    private BigDecimal loanAmount;

    private String color;

    private String bankName;
}
