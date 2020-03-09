package com.nw.networth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private float checking;
    private float savings;
    private float moneyMarket;
    private float bonds;
    private float cd;
    private float lifeInsurance;

}
