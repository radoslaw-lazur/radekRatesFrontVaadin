package com.radekrates.front.domain.iban;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IbanToUserDto {
    private String userEmail;
    private String iban;
}
