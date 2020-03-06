package com.nw.networth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private float brokerage;
    private float otherBrokerage;
    private float ira;
    private float rothIra;
    private float work401kor403b;
    private float sepIra;
    private float otherPlans;
    private float pension;
    private float annuity;
    private float realEstate;
    private float soleProprietorship;
    private float cCorporation;
    private float sCorporation;
    private float llc;
    private float otherBusiness;

}
