package com.mazurenko.accounts.service.client;

import com.mazurenko.accounts.model.Customer;
import com.mazurenko.accounts.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name="loans")
public interface LoansFeignClient {

    @GetMapping("/myLoans")
    List<Loan> getLoans(@RequestHeader("eazybank-correlation-id") String correlationId,
                        @RequestBody Customer customer);
}
