package com.tave.gangnam.week3.assigment.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDto {

    private Long loanId;

    private String loanName;

    private double loanAmount;

    private String color;

    private String bankName;
}
