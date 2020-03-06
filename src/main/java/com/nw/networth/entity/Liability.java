package com.nw.networth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Liability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private float creditCardBalance;
    private float estimatedIncomeTax;
    private float otherBills;
    private float homeMortgage;
    private float homeEquityLoan;
    private float rentalMortgage;
    private float carLoans;
    private float studentLoans;
    private float lifeInsurance;
    private float otherLongTerm;
}
