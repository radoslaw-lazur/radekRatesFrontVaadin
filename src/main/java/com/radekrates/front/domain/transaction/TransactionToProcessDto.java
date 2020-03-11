package com.radekrates.front.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionToProcessDto {
    private String userEmail;
    private String inputIbanNumber;
    private String outputIbanNumber;
    private String currencyPair;
    private double inputValue;
}
