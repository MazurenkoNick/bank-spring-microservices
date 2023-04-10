package com.mazurenko.accounts.service.client;

import com.mazurenko.accounts.model.Card;
import com.mazurenko.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name="cards")
public interface CardsFeignClient {

    @GetMapping("/myCards")
    List<Card> getCardDetails(@RequestBody Customer customer);
}
