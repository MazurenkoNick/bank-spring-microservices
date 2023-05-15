package com.mazurenko.accounts.service.client;

import com.mazurenko.accounts.model.Customer;
import com.mazurenko.accounts.model.Loan;
import com.mazurenko.accounts.service.fallback.LoansFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Primary
@FeignClient(name="loans", fallback = LoansFeignClientFallback.class)
public interface LoansFeignClient {

    @GetMapping("/myLoans")
    List<Loan> getLoans(@RequestHeader(value = "eazybank-correlation-id", required = false) String correlationId,
                        @RequestBody Customer customer);
}
