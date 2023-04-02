package com.mazurenko.cards.controller;

import com.mazurenko.cards.model.Card;
import com.mazurenko.cards.model.Customer;
import com.mazurenko.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        return cardRepository.findByCustomerId(customer.getCustomerId());
    }
}
