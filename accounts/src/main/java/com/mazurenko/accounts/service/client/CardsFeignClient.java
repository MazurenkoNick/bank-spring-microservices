package com.mazurenko.accounts.service.client;

import com.mazurenko.accounts.model.Card;
import com.mazurenko.accounts.model.Customer;
import com.mazurenko.accounts.service.fallback.CardsFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@Primary
@FeignClient(name="cards", fallback = CardsFeignClientFallback.class)
public interface CardsFeignClient {

    @GetMapping("/myCards")
    List<Card> getCardDetails(@RequestHeader(value = "eazybank-correlation-id", required = false) String correlationId,
                              @RequestBody Customer customer);
}
