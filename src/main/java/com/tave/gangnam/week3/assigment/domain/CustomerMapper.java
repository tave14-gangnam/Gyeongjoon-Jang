package com.tave.gangnam.week3.assigment.domain;

import com.tave.gangnam.week3.assigment.dto.CustomerRequestDto;
import com.tave.gangnam.week3.assigment.dto.CustomerResponseDto;

public class CustomerMapper {

    // Dto -> Entity
    public static Customer toEntity(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .customerName(customerRequestDto.getCustomerName())
                .age(customerRequestDto.getAge())
                .password(customerRequestDto.getPassword())
                .build();
    }

    // Entity -> Dto
    public static CustomerResponseDto toDto(Customer customer) {
        return CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName() != null ? customer.getCustomerName() : "NONE")
                .age(customer.getAge())
                .password(customer.getPassword() != null ? customer.getPassword() : "NONE")
                .build();
    }
}
