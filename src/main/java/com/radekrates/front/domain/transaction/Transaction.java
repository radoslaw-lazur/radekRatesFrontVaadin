package com.radekrates.front.domain.transaction;


import java.util.Objects;

public class Transaction {
    private String date;
    private String userEmail;
    private String inputIbanNumber;
    private String outputIbanNumber;
    private String currencyPair;
    private String inputValue;
    private String outputValue;
    private String purchased;
    private String sold;
    private String difference;

    public Transaction(String date, String userEmail, String inputIbanNumber, String outputIbanNumber,
                       String currencyPair, String inputValue, String outputValue, String purchased,
                       String sold, String difference) {
        this.date = date;
        this.userEmail = userEmail;
        this.inputIbanNumber = inputIbanNumber;
        this.outputIbanNumber = outputIbanNumber;
        this.currencyPair = currencyPair;
        this.inputValue = inputValue;
        this.outputValue = outputValue;
        this.purchased = purchased;
        this.sold = sold;
        this.difference = difference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public String getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(String outputValue) {
        this.outputValue = outputValue;
    }

    public String getPurchased() {
        return purchased;
    }

    public void setPurchased(String purchased) {
        this.purchased = purchased;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(inputIbanNumber, that.inputIbanNumber) &&
                Objects.equals(outputIbanNumber, that.outputIbanNumber) &&
                Objects.equals(currencyPair, that.currencyPair) &&
                Objects.equals(inputValue, that.inputValue) &&
                Objects.equals(outputValue, that.outputValue) &&
                Objects.equals(purchased, that.purchased) &&
                Objects.equals(sold, that.sold) &&
                Objects.equals(difference, that.difference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, userEmail, inputIbanNumber, outputIbanNumber, currencyPair, inputValue, outputValue, purchased, sold, difference);
    }
}
