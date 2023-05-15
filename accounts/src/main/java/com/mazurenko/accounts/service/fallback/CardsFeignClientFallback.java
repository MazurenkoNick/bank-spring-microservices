package com.mazurenko.accounts.service.fallback;

import com.mazurenko.accounts.model.Card;
import com.mazurenko.accounts.model.Customer;
import com.mazurenko.accounts.service.client.CardsFeignClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class CardsFeignClientFallback implements CardsFeignClient {


    @Override
    public List<Card> getCardDetails(String correlationId, Customer customer) {
        log.error("Cards microservice is down");
        return new ArrayList<>();
    }
}
