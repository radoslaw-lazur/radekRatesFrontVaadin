package com.radekrates.front.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.radekrates.front.domain.iban.IbanDto;
import com.radekrates.front.domain.transaction.TransactionDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRelatedToUser {
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userFirstName")
    private String userFirstName;
    @JsonProperty("userLastName")
    private String userLastName;
    @JsonProperty("ibans")
    private List<IbanDto> ibans;
    @JsonProperty("transactions")
    private List<TransactionDto> transactions;

}
