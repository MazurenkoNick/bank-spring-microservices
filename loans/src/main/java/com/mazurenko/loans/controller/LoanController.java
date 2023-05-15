package com.mazurenko.loans.controller;

import com.mazurenko.loans.model.Customer;
import com.mazurenko.loans.model.Loan;
import com.mazurenko.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Value("${loans.message}")
    private String message;

    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(
            @RequestHeader(value = "eazybank-correlation-id", required = false) String correlationId,
            @RequestBody Customer customerDto) {
        System.out.println(message);
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerDto.getCustomerId());
    }
}
