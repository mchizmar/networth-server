package com.nw.networth.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UseAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private float principalHome;
    private float vacationHome;
    private float motors;
    private float homeFurnishings;
    private float collectibles;
    private float jewelry;
    private float other;
}
