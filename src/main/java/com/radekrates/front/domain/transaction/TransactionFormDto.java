package com.radekrates.front.domain.transaction;


public class TransactionFormDto {
    private String inputIbanNumber;
    private String outputIbanNumber;
    private String inputValue;

    public TransactionFormDto(String inputIbanNumber, String outputIbanNumber, String inputValue) {
        this.inputIbanNumber = inputIbanNumber;
        this.outputIbanNumber = outputIbanNumber;
        this.inputValue = inputValue;
    }

    public String getInputIbanNumber() {
        return inputIbanNumber;
    }

    public void setInputIbanNumber(String inputIbanNumber) {
        this.inputIbanNumber = inputIbanNumber;
    }

    public String getOutputIbanNumber() {
        return outputIbanNumber;
    }

    public void setOutputIbanNumber(String outputIbanNumber) {
        this.outputIbanNumber = outputIbanNumber;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
