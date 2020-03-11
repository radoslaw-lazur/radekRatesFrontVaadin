package com.radekrates.front.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.radekrates.front.domain.iban.IbanDto;
import com.radekrates.front.domain.transaction.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRelatedToUser {
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userFirstName")
    private String userFirstName;
    @JsonProperty("userLastName")
    private String userLastName;
    @JsonProperty("ibans")
    private Set<IbanDto> ibans;
    @JsonProperty("transactions")
    private Set<TransactionDto> transactions;

}
