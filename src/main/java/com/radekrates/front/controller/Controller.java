package com.radekrates.front.controller;

import com.radekrates.front.client.RadekRatesClient;
import com.radekrates.front.domain.iban.IbanDto;
import com.radekrates.front.domain.iban.IbanToUserDto;
import com.radekrates.front.domain.transaction.TransactionToProcessDto;
import com.radekrates.front.domain.user.DataRelatedToUser;
import com.radekrates.front.domain.user.UserDto;
import com.radekrates.front.domain.user.UserLogInDto;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/front")
public class Controller {
    @Autowired
    private RadekRatesClient radekRatesClient;


    @GetMapping(value = "getUserData")
    public void getData() {
        UserLogInDto userLogInDto = new UserLogInDto("radoslaw.lazur@gmail.com", "javaMM!@3#$");
        DataRelatedToUser dataRelatedToUser = radekRatesClient.getDataRelatedToUser(userLogInDto);
    }

    @GetMapping(value = "saveIban")
    public void saveIban() {
        IbanDto ibanDto1 = new IbanDto(
                "ING",
                "Krakow",
                "PL",
                "EUR",
                "PL111111111111111114"
        );
        IbanDto ibanDto2 = new IbanDto(
                "ING",
                "Krakow",
                "DE",
                "PLN",
                "DE111111111111111114"
        );
        radekRatesClient.saveIban(ibanDto1);
        radekRatesClient.saveIban(ibanDto2);
    }

    @GetMapping(value = "saveIbanToUser")
    public void saveIbanToUser() {
        IbanToUserDto ibanToUserDto1 = new IbanToUserDto("radoslaw.lazur@gmail.com", "PL111111111111111114");
        IbanToUserDto ibanToUserDto2 = new IbanToUserDto("radoslaw.lazur@gmail.com", "DE111111111111111114");
        radekRatesClient.saveIbanToUser(ibanToUserDto1);
        radekRatesClient.saveIbanToUser(ibanToUserDto2);
    }

    @GetMapping(value = "saveTransaction")
    public void saveTransaction() {
        TransactionToProcessDto transaction = new TransactionToProcessDto(
                "radoslaw.lazur@gmail.com",
                "PL111111111111111114",
                "DE111111111111111114",
                "EUR-PLN",
                100
        );
        radekRatesClient.saveTransaction(transaction);
    }

    @GetMapping(value = "saveUser")
    public void saveUser() {
        UserDto userDto = new UserDto(
                "radoslaw.lazur@gmail.com",
                "javaMM!@3#$",
                "Radoslaw",
                "Lazur",
                30,
                "Poland",
                false,
                false
        );
        radekRatesClient.saveUser(userDto);
    }
}
