package com.td.DTOdemo.service;

import com.td.DTOdemo.dto.request.CustomerAccountRequestDto;
import com.td.DTOdemo.dto.response.CustomerAccountResponseDto;
import com.td.DTOdemo.models.CustomerAccount;
import com.td.DTOdemo.models.CustomerAccountAuth;
import com.td.DTOdemo.repository.CustomerAccountAuthRepository;
import com.td.DTOdemo.repository.CustomerAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
public class CustomerAccountService {
    @Autowired
    CustomerAccountAuthRepository customerAccountAuthRepository;
    @Autowired
    CustomerAccountRepository customerAccountRepository;

    @Autowired
    ModelMapper modelMapper;

    public CustomerAccountResponseDto signup(CustomerAccountRequestDto customerAccountRequestDto) throws Exception {

        Optional<CustomerAccount> customerAccount = this.customerAccountRepository.findCustomerAccountByName(
                customerAccountRequestDto.getName()
        );

        if (customerAccount.isPresent()) {
            throw new Exception(customerAccountRequestDto.getName() + "has an existing account");
        }

        CustomerAccount customerAccountNew = modelMapper.map(customerAccountRequestDto, CustomerAccount.class);
        CustomerAccountResponseDto customerAccountResponseDto = modelMapper.map(this.customerAccountAuthRepository.save(modelMapper.map(customerAccountRequestDto, CustomerAccountAuth.class)), CustomerAccountResponseDto.class);
        customerAccountResponseDto.setEmail(customerAccountNew.getEmail());
        customerAccountResponseDto.setPhoneNumber(customerAccountNew.getPhoneNumber());
        return customerAccountResponseDto;
    }

    public CustomerAccountResponseDto updateCustomerAccount(CustomerAccountRequestDto customerAccountRequestDto) throws Exception {
        CustomerAccountAuth customerAccountAuth = this.customerAccountAuthRepository.findCustomerAccountAuthByUsername(customerAccountRequestDto.getUsername()).orElse(null);
        if (customerAccountAuth == null) {
            throw new Exception("Customer does not exist");
        }

        CustomerAccount customerAccount = customerAccountAuth.getCustomerAccount();

        if (customerAccountRequestDto.getName() != null) {
            customerAccount.setName(customerAccountRequestDto.getName());
        }
        if (customerAccountRequestDto.getPhoneNumber() != 0) {
            customerAccount.setPhoneNumber(customerAccountRequestDto.getPhoneNumber());
        }
        if (customerAccountRequestDto.getEmail() != null) {
            customerAccount.setEmail(customerAccountRequestDto.getEmail());
        }
        if (customerAccountRequestDto.getAccountType() != null) {
            customerAccount.setAccountType(customerAccountRequestDto.getAccountType());
        }
        if (customerAccountRequestDto.getPassword() != null) {
            customerAccountAuth.setPassword(customerAccountRequestDto.getPassword());
        }
        if (customerAccountRequestDto.getSecurityQuestion() != null) {
            customerAccountAuth.setSecurityQuestion(customerAccountRequestDto.getSecurityQuestion());
        }
        if (customerAccountRequestDto.getSecurityAnswer() != null) {
            customerAccountAuth.setSecurityAnswer(customerAccountRequestDto.getSecurityAnswer());
        }
        CustomerAccountResponseDto customerAccountResponseDto = modelMapper.map(this.customerAccountAuthRepository.save(customerAccountAuth), CustomerAccountResponseDto.class);
        customerAccountResponseDto.setEmail(customerAccount.getEmail());
        customerAccountResponseDto.setPhoneNumber(customerAccount.getPhoneNumber());
        return customerAccountResponseDto;
    }
}
