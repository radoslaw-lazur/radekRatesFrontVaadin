package com.radekrates.front.domain.iban;

public class IbanToSaveDto {
    private String bankName;
    private String bankLocalisation;
    private String countryCode;
    private String currencyCode;
    private String ibanNumber;

    public IbanToSaveDto(String bankName, String bankLocalisation, String countryCode,
                         String currencyCode, String ibanNumber) {
        this.bankName = bankName;
        this.bankLocalisation = bankLocalisation;
        this.countryCode = countryCode;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }
}
