package com.radekrates.front.domain.iban;

public class IbanFormDto {
    private String bankName;
    private String bankLocalisation;
    private CurrencyType currencyCode;
    private String ibanNumber;

    public IbanFormDto(String bankName, String bankLocalisation, CurrencyType currencyCode, String ibanNumber) {
        this.bankName = bankName;
        this.bankLocalisation = bankLocalisation;
        this.currencyCode = currencyCode;
        this.ibanNumber = ibanNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLocalisation() {
        return bankLocalisation;
    }

    public void setBankLocalisation(String bankLocalisation) {
        this.bankLocalisation = bankLocalisation;
    }

    public CurrencyType getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyType currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }
}
