package com.td.DTOdemo.controller;

import com.td.DTOdemo.dto.request.CustomerAccountRequestDto;
import com.td.DTOdemo.dto.request.LombokRequestDto;
import com.td.DTOdemo.dto.request.RecordRequestDto;
import com.td.DTOdemo.dto.response.CustomerAccountResponseDto;
import com.td.DTOdemo.dto.response.LombokResponseDto;
import com.td.DTOdemo.service.CustomerAccountService;
import com.td.DTOdemo.service.LombokRecordCustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customerAccount")
public class CustomerAccountController {
    @Autowired
    CustomerAccountService customerAccountService;

    @Autowired
    LombokRecordCustomerService lombokRecordCustomerService;

    @PostMapping(value = "/signup")
    private ResponseEntity<CustomerAccountResponseDto> signupCustomer(
            @RequestBody @Valid CustomerAccountRequestDto customerAccountRequestDto
            ) throws Exception {
        return new ResponseEntity<>(this.customerAccountService.signup(customerAccountRequestDto), HttpStatus.OK);
    }
    @PutMapping(value = "/update")
    private ResponseEntity<CustomerAccountResponseDto> updateCustomerAccount(
            @RequestBody @Valid CustomerAccountRequestDto customerAccountRequestDto
    ) throws Exception {
        return new ResponseEntity<>(this.customerAccountService.updateCustomerAccount(customerAccountRequestDto), HttpStatus.OK);
    }
    @PostMapping(value = "/lombok/signup")
    private ResponseEntity<LombokResponseDto> signupCustomer(
            @RequestBody @Valid LombokRequestDto lombokRequestDto
    ) throws Exception {
        return new ResponseEntity<>(this.lombokRecordCustomerService.signup(lombokRequestDto), HttpStatus.OK);
    }
    @PutMapping(value = "/record/update")
    private ResponseEntity<LombokResponseDto> updateCustomerAccount(
            @RequestBody @Valid RecordRequestDto recordRequestDto
    ) throws Exception {
        return new ResponseEntity<>(this.lombokRecordCustomerService.updateCustomerAccount(recordRequestDto), HttpStatus.OK);
    }
}
