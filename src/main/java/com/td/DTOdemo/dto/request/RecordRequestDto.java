package com.td.DTOdemo.dto.request;

public record RecordRequestDto(
        String name,
        int phoneNumber,
        String email,
        String accountType,
        String username,
        String password,
        String securityQuestion,
        String securityAnswer
) {}
