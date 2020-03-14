package com.radekrates.front.domain.user;

public class UserSignInFormDto {
    private String email;
    private String password;
    private String userFirstName;
    private String userLastName;
    private AgeType age;
    private CountryType country;

    public UserSignInFormDto(String email, String password, String userFirstName,
                             String userLastName, AgeType age, CountryType country) {
        this.email = email;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.age = age;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public AgeType getAge() {
        return age;
    }

    public void setAge(AgeType age) {
        this.age = age;
    }

    public CountryType getCountry() {
        return country;
    }

    public void setCountry(CountryType country) {
        this.country = country;
    }
}
