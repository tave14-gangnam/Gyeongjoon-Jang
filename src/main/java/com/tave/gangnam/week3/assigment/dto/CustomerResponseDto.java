package com.tave.gangnam.week3.assigment.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {

    private Long customerId;

    private String customerName;

    private int age;

    private int password;
}
