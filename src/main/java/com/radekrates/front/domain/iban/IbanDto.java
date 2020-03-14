package com.radekrates.front.domain.iban;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IbanDto {
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("bankLocalisation")
    private String bankLocalisation;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("ibanNumber")
    private String ibanNumber;
}
