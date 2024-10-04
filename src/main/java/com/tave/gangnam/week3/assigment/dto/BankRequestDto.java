package com.tave.gangnam.week3.assigment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankRequestDto {

    private String bankName;

    private Long installmentSavings;

}
