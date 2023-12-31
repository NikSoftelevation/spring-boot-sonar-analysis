package com.spring.sonar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String jobProfile;
}
