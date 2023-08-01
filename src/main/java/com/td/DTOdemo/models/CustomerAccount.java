package com.td.DTOdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.util.List;


@Entity
@Table
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String username;
    @Column
    private int phoneNumber;
    @Column
    private String email;
    @Column
    private String accountType;
    @JsonIgnore
    @OneToMany(mappedBy = "customerAccount")
    private List<CustomerSubscription> customerSubscriptions;

    public CustomerAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<CustomerSubscription> getCustomerSubscriptions() {
        return customerSubscriptions;
    }

    public void setCustomerSubscriptions(List<CustomerSubscription> customerSubscriptions) {
        this.customerSubscriptions = customerSubscriptions;
    }
}
