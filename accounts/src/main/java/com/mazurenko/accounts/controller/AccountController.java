package com.mazurenko.accounts.controller;

import com.mazurenko.accounts.model.*;
import com.mazurenko.accounts.repository.AccountRepository;
import com.mazurenko.accounts.service.client.CardsFeignClient;
import com.mazurenko.accounts.service.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardsFeignClient cardsFeignClient;

    @Autowired
    private LoansFeignClient loansFeignClient;

    @GetMapping("/myAccount/{customerId}")
    public Account getAccountDetails(@PathVariable long customerId) {
        return accountRepository.findByCustomerCustomerId(customerId);
    }

    @GetMapping("/customerDetails")
    public CustomerDetails getCustomerDetails(@RequestBody Customer customer) {
        Account account = accountRepository.findByCustomerCustomerId(customer.getCustomerId());
        List<Card> cards = cardsFeignClient.getCardDetails(customer);
        List<Loan> loans = loansFeignClient.getLoans(customer);

        return CustomerDetails.builder()
                .account(account)
                .loans(loans)
                .cards(cards)
                .build();
    }

}
