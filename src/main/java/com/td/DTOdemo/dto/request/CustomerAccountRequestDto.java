package com.td.DTOdemo.dto.request;

public class CustomerAccountRequestDto {
    private String name;
    private int phoneNumber;
    private String email;
    private String accountType;
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;

    public CustomerAccountRequestDto() {
    }

    public CustomerAccountRequestDto(String name, int phoneNumber, String email, String accountType, String username, String password, String securityQuestion, String securityAnswer) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountType = accountType;
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
}
