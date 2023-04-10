package com.mazurenko.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class Loan {

    private int loanNumber;
    private int customerId;
    private Date startDt;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private LocalDateTime createDt;
}
