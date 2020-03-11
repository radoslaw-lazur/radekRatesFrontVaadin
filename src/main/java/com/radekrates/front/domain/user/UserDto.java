package com.radekrates.front.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String userFirstName;
    private String userLastName;
    private int age;
    private String country;
    private boolean isActive;
    private boolean isBlocked;
}
