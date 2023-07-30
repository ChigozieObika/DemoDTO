package com.td.DTOdemo.repository;

import com.td.DTOdemo.models.CustomerAccount;
import com.td.DTOdemo.models.CustomerAccountAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAccountAuthRepository extends JpaRepository<CustomerAccountAuth, Integer> {
    Optional<CustomerAccountAuth> findCustomerAccountAuthByUsername(String username);

    Optional<CustomerAccountAuth> findCustomerAccountAuthByCustomerAccount(CustomerAccount customerAccount);

}
