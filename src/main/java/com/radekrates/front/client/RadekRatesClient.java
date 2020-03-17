package com.radekrates.front.client;

import com.radekrates.front.domain.iban.IbanToSaveDto;
import com.radekrates.front.domain.iban.IbanToUserDto;
import com.radekrates.front.domain.transaction.TransactionToProcessDto;
import com.radekrates.front.domain.user.DataRelatedToUser;
import com.radekrates.front.domain.user.UserDto;
import com.radekrates.front.domain.user.UserLogInDto;
import com.radekrates.front.domain.user.ValidatedUser;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static java.util.Optional.ofNullable;

@Component
@Slf4j
public class RadekRatesClient {
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private JSONObject jsonObject;

    @Autowired
    public RadekRatesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DataRelatedToUser getDataRelatedToUser(UserLogInDto userLogInDto) {
        try {
            prepareTransfer();
            jsonObject.put("userEmail", userLogInDto.getUserEmail());
            jsonObject.put("password", userLogInDto.getPassword());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            return ofNullable( restTemplate.postForObject(getUserDataURL(), request, DataRelatedToUser.class))
                    .orElseThrow(RuntimeException::new);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
            return new DataRelatedToUser();
        }
    }

    public ValidatedUser getUserValidation(UserLogInDto userLogInDto) {
        try {
            prepareTransfer();
            jsonObject.put("userEmail", userLogInDto.getUserEmail());
            jsonObject.put("password", userLogInDto.getPassword());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            return ofNullable( restTemplate.postForObject(getUserValidationURL(), request, ValidatedUser.class))
                    .orElseThrow(RuntimeException::new);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
            return new ValidatedUser();
        }
    }

    public void saveIban(IbanToSaveDto ibanDto) {
        try {
            prepareTransfer();
            jsonObject.put("bankName", ibanDto.getBankName());
            jsonObject.put("bankLocalisation", ibanDto.getBankLocalisation());
            jsonObject.put("countryCode", ibanDto.getCountryCode());
            jsonObject.put("currencyCode", ibanDto.getCurrencyCode());
            jsonObject.put("ibanNumber", ibanDto.getIbanNumber());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            restTemplate.postForObject(getSaveIbanURL(), request, Void.class);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    public void saveIbanToUser(IbanToUserDto ibanToUserDto) {
        try {
            prepareTransfer();
            jsonObject.put("userEmail", ibanToUserDto.getUserEmail());
            jsonObject.put("iban", ibanToUserDto.getIban());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            restTemplate.postForObject(getSaveIbanToUserURL(), request, Void.class);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    public void saveTransaction(TransactionToProcessDto transaction) {
        try {
            prepareTransfer();
            jsonObject.put("userEmail", transaction.getUserEmail());
            jsonObject.put("inputIbanNumber", transaction.getInputIbanNumber());
            jsonObject.put("outputIbanNumber", transaction.getOutputIbanNumber());
            jsonObject.put("currencyPair", transaction.getCurrencyPair());
            jsonObject.put("inputValue", transaction.getInputValue());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            restTemplate.postForObject(getSaveTransactionURL(), request, Void.class);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    public void saveUser(UserDto userDto) {
        try {
            prepareTransfer();
            jsonObject.put("email", userDto.getEmail());
            jsonObject.put("password", userDto.getPassword());
            jsonObject.put("userFirstName", userDto.getUserFirstName());
            jsonObject.put("userLastName", userDto.getUserLastName());
            jsonObject.put("age", userDto.getAge());
            jsonObject.put("country", userDto.getCountry());
            jsonObject.put("isActive", userDto.isActive());
            jsonObject.put("isBlocked", userDto.isBlocked());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            restTemplate.postForObject(getSaveUserURL(), request, Void.class);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    public void remindPassword(String userEmail) {
        try {
            prepareTransfer();
            jsonObject.put("userEmail", userEmail);
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            restTemplate.postForObject(getPasswordReminderURL(), request, Void.class);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    public void deleteIban(String ibanId) {
        try {
            restTemplate.delete(getDeleteIbanByIdURL(ibanId));
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    public void updateIban(IbanToSaveDto ibanDto) {
        try {
            prepareTransfer();
            jsonObject.put("bankName", ibanDto.getBankName());
            jsonObject.put("bankLocalisation", ibanDto.getBankLocalisation());
            jsonObject.put("countryCode", ibanDto.getCountryCode());
            jsonObject.put("currencyCode", ibanDto.getCurrencyCode());
            jsonObject.put("ibanNumber", ibanDto.getIbanNumber());
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            restTemplate.put(getUpdateIbanURL(), request, Void.class);
        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
    }

    private void prepareTransfer() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        jsonObject = new JSONObject();
    }

    private String getUserDataURL() {
        return "http://localhost:8080/v1/dataUser";
    }

    private String getUserValidationURL() {
        return "http://localhost:8080/v1/validate";
    }

    private String getSaveIbanURL() {
        return "http://localhost:8080/v1/ibans";
    }

    private String getSaveIbanToUserURL() {
        return "http://localhost:8080/v1/ibanToUser";
    }

    private String getUpdateIbanURL() {
        return "http://localhost:8080/v1/ibans";
    }

    private String getSaveTransactionURL() {
        return "http://localhost:8080/v1/transactions";
    }

    private String getSaveUserURL() {
        return "http://localhost:8080/v1/users";
    }

    private String getDeleteIbanByIdURL(String ibanId) {
        return "http://localhost:8080/v1/ibans/" + ibanId;
    }

    private String getPasswordReminderURL() {
        return "http://localhost:8080/v1/password";
    }
}
