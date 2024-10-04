package com.tave.gangnam.week3.assigment.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BankResponseDto {

    private Long bankId;

    private String bankName;

    private String customerName;
}
