package com.td.DTOdemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LombokRequestDto {
    private String name;
    private int phoneNumber;
    private String email;
    private String accountType;
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
}
