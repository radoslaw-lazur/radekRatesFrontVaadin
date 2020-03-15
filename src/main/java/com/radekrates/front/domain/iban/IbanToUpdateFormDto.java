package com.radekrates.front.domain.iban;

public class IbanToUpdateFormDto {
    private String bankNameUpdate;
    private String bankLocalisationUpdate;
    private CurrencyType currencyCodeUpdate;
    private String ibanNumberUpdate;

    public IbanToUpdateFormDto(String bankNameUpdate, String bankLocalisationUpdate,
                               CurrencyType currencyCodeUpdate, String ibanNumberUpdate) {
        this.bankNameUpdate = bankNameUpdate;
        this.bankLocalisationUpdate = bankLocalisationUpdate;
        this.currencyCodeUpdate = currencyCodeUpdate;
        this.ibanNumberUpdate = ibanNumberUpdate;
    }

    public String getBankNameUpdate() {
        return bankNameUpdate;
    }

    public void setBankNameUpdate(String bankNameUpdate) {
        this.bankNameUpdate = bankNameUpdate;
    }

    public String getBankLocalisationUpdate() {
        return bankLocalisationUpdate;
    }

    public void setBankLocalisationUpdate(String bankLocalisationUpdate) {
        this.bankLocalisationUpdate = bankLocalisationUpdate;
    }

    public CurrencyType getCurrencyCodeUpdate() {
        return currencyCodeUpdate;
    }

    public void setCurrencyCodeUpdate(CurrencyType currencyCodeUpdate) {
        this.currencyCodeUpdate = currencyCodeUpdate;
    }

    public String getIbanNumberUpdate() {
        return ibanNumberUpdate;
    }

    public void setIbanNumberUpdate(String ibanNumberUpdate) {
        this.ibanNumberUpdate = ibanNumberUpdate;
    }
}
