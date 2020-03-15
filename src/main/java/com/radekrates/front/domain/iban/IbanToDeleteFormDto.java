package com.radekrates.front.domain.iban;

public class IbanToDeleteFormDto {
    private String ibanNumber;

    public IbanToDeleteFormDto(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }
}
