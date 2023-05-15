package com.mazurenko.cards.controller;

import com.mazurenko.cards.model.Card;
import com.mazurenko.cards.model.Customer;
import com.mazurenko.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @Value("${cards.number}")
    private String number;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestBody Customer customer) {
        System.out.println(number + "correlationID: " + correlationId);
        return cardRepository.findByCustomerId(customer.getCustomerId());
    }
}
