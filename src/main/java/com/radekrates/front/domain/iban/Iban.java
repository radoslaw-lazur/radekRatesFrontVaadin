package com.radekrates.front.domain.iban;

import java.util.Objects;

public class Iban {
    private String bankName;
    private String bankLocalisation;
    private String currencyCode;
    private String ibanNumber;

    public Iban(String bankName, String bankLocalisation, String currencyCode, String ibanNumber) {
        this.bankName = bankName;
        this.bankLocalisation = bankLocalisation;
        this.currencyCode = currencyCode;
        this.ibanNumber = ibanNumber;
    }

    public Iban() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iban iban = (Iban) o;
        return Objects.equals(bankName, iban.bankName) &&
                Objects.equals(bankLocalisation, iban.bankLocalisation) &&
                Objects.equals(currencyCode, iban.currencyCode) &&
                Objects.equals(ibanNumber, iban.ibanNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, bankLocalisation, currencyCode, ibanNumber);
    }
}
