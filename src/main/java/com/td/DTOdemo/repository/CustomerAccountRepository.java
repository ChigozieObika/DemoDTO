package com.td.DTOdemo.repository;

import com.td.DTOdemo.models.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer> {
    Optional<CustomerAccount> findCustomerAccountByUsername(String name);
}
