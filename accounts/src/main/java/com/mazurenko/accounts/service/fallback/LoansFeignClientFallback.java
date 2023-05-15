package com.mazurenko.accounts.service.fallback;

import com.mazurenko.accounts.model.Customer;
import com.mazurenko.accounts.model.Loan;
import com.mazurenko.accounts.service.client.LoansFeignClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class LoansFeignClientFallback implements LoansFeignClient {

    @Override
    public List<Loan> getLoans(String correlationId, Customer customer) {
        log.error("Loans microservice is down");
        return new ArrayList<>();
    }
}
