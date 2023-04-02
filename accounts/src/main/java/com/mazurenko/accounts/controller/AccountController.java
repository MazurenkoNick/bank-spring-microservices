package com.mazurenko.accounts.controller;

import com.mazurenko.accounts.model.Account;
import com.mazurenko.accounts.model.Customer;
import com.mazurenko.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/myAccount/{customerId}")
    public Account getAccountDetails(@PathVariable long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }
}
