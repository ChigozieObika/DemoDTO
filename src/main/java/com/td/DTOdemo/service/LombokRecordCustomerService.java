package com.td.DTOdemo.service;

import com.td.DTOdemo.dto.request.CustomerAccountRequestDto;
import com.td.DTOdemo.dto.request.LombokRequestDto;
import com.td.DTOdemo.dto.request.RecordRequestDto;
import com.td.DTOdemo.dto.response.CustomerAccountResponseDto;
import com.td.DTOdemo.dto.response.LombokResponseDto;
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
public class LombokRecordCustomerService {
    @Autowired
    CustomerAccountAuthRepository customerAccountAuthRepository;
    @Autowired
    CustomerAccountRepository customerAccountRepository;

    @Autowired
    ModelMapper modelMapper;

    public LombokResponseDto signup(LombokRequestDto lombokRequestDto) throws Exception {

        Optional<CustomerAccount> customerAccount = this.customerAccountRepository.findCustomerAccountByUsername(
                lombokRequestDto.getUsername()
        );

        if (customerAccount.isPresent()) {
            throw new Exception(lombokRequestDto.getName() + "has an existing account");
        }

        CustomerAccount customerAccountNew = modelMapper.map(lombokRequestDto, CustomerAccount.class);
        CustomerAccountAuth customerAccountAuth = modelMapper.map(lombokRequestDto, CustomerAccountAuth.class);
        customerAccountAuth.setCustomerAccount(customerAccountNew);
        LombokResponseDto lombokResponseDto = modelMapper.map(this.customerAccountAuthRepository.save(customerAccountAuth), LombokResponseDto.class);
        lombokResponseDto.setEmail(customerAccountNew.getEmail());
        lombokResponseDto.setPhoneNumber(customerAccountNew.getPhoneNumber());
        return lombokResponseDto;
    }

    public LombokResponseDto updateCustomerAccount(RecordRequestDto recordRequestDto) throws Exception {
//        Optional<CustomerAccount> customerAccount1 = this.customerAccountRepository.findCustomerAccountByName(customerAccountRequestDto.getName());
        CustomerAccountAuth customerAccountAuth = this.customerAccountAuthRepository.findCustomerAccountAuthByName(recordRequestDto.name()).orElse(null);
        if (customerAccountAuth == null) {
            throw new Exception("Customer does not exist");
        }

        CustomerAccount customerAccount = customerAccountAuth.getCustomerAccount();

        if (recordRequestDto.phoneNumber() != 0) {
            customerAccount.setPhoneNumber(recordRequestDto.phoneNumber());
        }
        if (recordRequestDto.email() != null) {
            customerAccount.setEmail(recordRequestDto.email());
        }
        if (recordRequestDto.accountType() != null) {
            customerAccount.setAccountType(recordRequestDto.accountType());
        }

        if (recordRequestDto.name() != null) {
            customerAccountAuth.setName(recordRequestDto.name());
        }
        if (recordRequestDto.password() != null) {
            customerAccountAuth.setPassword(recordRequestDto.password());
        }
        if (recordRequestDto.securityQuestion() != null) {
            customerAccountAuth.setSecurityQuestion(recordRequestDto.securityQuestion());
        }
        if (recordRequestDto.securityAnswer() != null) {
            customerAccountAuth.setSecurityAnswer(recordRequestDto.securityAnswer());
        }
        LombokResponseDto lombokResponseDto = modelMapper.map(this.customerAccountAuthRepository.save(customerAccountAuth), LombokResponseDto.class);
        lombokResponseDto.setEmail(customerAccount.getEmail());
        lombokResponseDto.setPhoneNumber(customerAccount.getPhoneNumber());
        return lombokResponseDto;
    }
}
