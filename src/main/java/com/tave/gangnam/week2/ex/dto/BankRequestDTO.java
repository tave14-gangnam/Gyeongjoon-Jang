package com.tave.gangnam.week2.ex.dto;

import com.tave.gangnam.week2.ex.domain.BankUser;
import com.tave.gangnam.week2.ex.domain.BankUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankRequestDTO {

    private Long id;
    private BankUser bankUser;
    private Long installmentSavings;
    private Long loan;

    private String bankName;
}
