package com.radekrates.front.domain.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDto {
    @JsonProperty("uniqueKeyChain")
    private String uniqueKeyChain;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("inputIbanNumber")
    private String inputIbanNumber;
    @JsonProperty("outputIbanNumber")
    private String outputIbanNumber;
    @JsonProperty("pairOfCurrencies")
    private String pairOfCurrencies;
    @JsonProperty("inputValue")
    private String inputValue;
    @JsonProperty("outputValue")
    private String outputValue;
    @JsonProperty("apiCurrencyPurchaseMultiplier")
    private String apiCurrencyPurchaseMultiplier;
    @JsonProperty("currencySaleMultiplier")
    private String currencySaleMultiplier;
    @JsonProperty("profit")
    private String profit;
    @JsonProperty("date")
    private String date;
}
