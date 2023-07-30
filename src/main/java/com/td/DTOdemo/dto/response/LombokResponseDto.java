package com.td.DTOdemo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LombokResponseDto {
    private String username;
    private int phoneNumber;
    private String email;
}
