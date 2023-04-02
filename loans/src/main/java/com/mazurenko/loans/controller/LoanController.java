package com.mazurenko.loans.controller;

import com.mazurenko.loans.model.CustomerDto;
import com.mazurenko.loans.model.Loan;
import com.mazurenko.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestBody CustomerDto customerDto) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerDto.getCustomerId());
    }
}
