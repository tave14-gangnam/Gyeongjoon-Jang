package com.tave.gangnam.week2.ex.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;

    /**
     * 유저가 어떤은행 가입이 되었는지, 그리고 대출, 적금을 알아보는 프로그램
     * 은행에 유저 등록과 조회가 필요함
     **/

    // 대출
    private Long loan;

    // 적금
    private Long installmentSavings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankuser_id")
    private BankUser bankUser;

}
