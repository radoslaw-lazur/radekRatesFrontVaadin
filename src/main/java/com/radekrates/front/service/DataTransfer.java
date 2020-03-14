package com.radekrates.front.service;

import com.radekrates.front.client.RadekRatesClient;
import com.radekrates.front.domain.iban.Iban;
import com.radekrates.front.domain.iban.IbanDto;
import com.radekrates.front.domain.iban.IbanFormDto;
import com.radekrates.front.domain.iban.IbanToUserDto;
import com.radekrates.front.domain.transaction.Transaction;
import com.radekrates.front.domain.transaction.TransactionDto;
import com.radekrates.front.domain.transaction.TransactionFormDto;
import com.radekrates.front.domain.transaction.TransactionToProcessDto;
import com.radekrates.front.domain.user.UserDto;
import com.radekrates.front.domain.user.UserLogInDto;
import com.radekrates.front.domain.user.UserSignInFormDto;
import com.radekrates.front.domain.user.ValidatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DataTransfer {

    private RadekRatesClient radekRatesClient;

    @Autowired
    public DataTransfer(RadekRatesClient radekRatesClient) {
        this.radekRatesClient = radekRatesClient;
    }

    private UserLogInDto userToMain = new UserLogInDto(null, null);

    public UserLogInDto getUserToMain() {
        return userToMain;
    }

    public void setUserToMain(UserLogInDto userToMain) {
        this.userToMain = userToMain;
    }

    public ValidatedUser getUserValidation(UserLogInDto userLogInDto) {
        return radekRatesClient.getUserValidation(userLogInDto);
    }

    public List<Iban> getIbans(UserLogInDto userLogInDto, String flag, String query) {
        List<IbanDto> ibanDtos = radekRatesClient.getDataRelatedToUser(userLogInDto).getIbans();
        if (flag.equals("ibanNumber")) {
            return ibanDtos.stream()
                    .map(t -> new Iban(t.getBankName(), t.getBankLocalisation(), t.getCurrencyCode(), t.getIbanNumber()))
                    .filter(t -> t.getIbanNumber().contains(query))
                    .collect(Collectors.toList());
        } else if (flag.equals("currencyCode")){
            return ibanDtos.stream()
                    .map(t -> new Iban(t.getBankName(), t.getBankLocalisation(), t.getCurrencyCode(), t.getIbanNumber()))
                    .filter(t -> t.getCurrencyCode().contains(query))
                    .collect(Collectors.toList());
        } else {
            return ibanDtos.stream()
                    .map(t -> new Iban(t.getBankName(), t.getBankLocalisation(), t.getCurrencyCode(), t.getIbanNumber()))
                    .collect(Collectors.toList());
        }
    }

    public List<String> getIbansComboBox(UserLogInDto userLogInDto) {
        return radekRatesClient.getDataRelatedToUser(userLogInDto).getIbans().stream()
                .map(t -> t.getCurrencyCode() + "  " + t.getIbanNumber())
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactions(UserLogInDto userLogInDto, String flag, String query) {
        List<TransactionDto> transactionDtos = radekRatesClient.getDataRelatedToUser(userLogInDto).getTransactions();
        if (flag.equals("pair")) {
            return transactionDtos.stream()
                    .map(t -> new Transaction(t.getDate(), t.getUserEmail(), t.getInputIbanNumber(),
                            t.getOutputIbanNumber(), t.getPairOfCurrencies(), t.getInputValue(),
                            t.getOutputValue(), t.getApiCurrencyPurchaseMultiplier(),
                            t.getCurrencySaleMultiplier(), t.getProfit()))
                    .filter(t -> t.getCurrencyPair().contains(query))
                    .collect(Collectors.toList());
        } else {
            return transactionDtos.stream()
                    .map(t -> new Transaction(t.getDate(), t.getUserEmail(), t.getInputIbanNumber(),
                            t.getOutputIbanNumber(), t.getPairOfCurrencies(), t.getInputValue(),
                            t.getOutputValue(), t.getApiCurrencyPurchaseMultiplier(),
                            t.getCurrencySaleMultiplier(), t.getProfit()))
                    .collect(Collectors.toList());
        }
    }

    public void saveIban(IbanFormDto ibanFormDto, String userEmail) {
        IbanDto ibanDto = new IbanDto(ibanFormDto.getBankName(), ibanFormDto.getBankLocalisation(),
                ibanFormDto.getIbanNumber().substring(0, 2), ibanFormDto.getCurrencyCode().toString(),
                ibanFormDto.getIbanNumber());
        radekRatesClient.saveIban(ibanDto);
        radekRatesClient.saveIbanToUser(new IbanToUserDto(userEmail, ibanDto.getIbanNumber()));
    }

    public void saveTransaction(TransactionFormDto transactionFormDto, String userEmail) {
        String currencyPair = transactionFormDto.getInputIbanNumber().substring(0, 3) + "-" +
                transactionFormDto.getOutputIbanNumber().substring(0, 3);
        String inputIbanNumber = transactionFormDto.getInputIbanNumber().substring(5, 25);
        String outputIbanNumber = transactionFormDto.getOutputIbanNumber().substring(5, 25);
        TransactionToProcessDto transactionToProcessDto =
                new TransactionToProcessDto(userEmail, inputIbanNumber, outputIbanNumber, currencyPair,
                        Double.parseDouble(transactionFormDto.getInputValue()));
        radekRatesClient.saveTransaction(transactionToProcessDto);
    }

    public void saveUser(UserSignInFormDto userSignInFormDto) {
        radekRatesClient.saveUser(new UserDto(userSignInFormDto.getEmail(), userSignInFormDto.getPassword(),
                userSignInFormDto.getUserFirstName(), userSignInFormDto.getUserLastName(),
                Integer.parseInt(userSignInFormDto.getAge().toString().substring(4, 6)), userSignInFormDto.getCountry().toString(),
                false, false));
    }
}
