package com.mazurenko.accounts.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CustomerDetails {

    private Account account;
    private List<Card> cards;
    private List<Loan> loans;
}
