package com.example.testweb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Roma Dziuba <rodzi@smile.fr>
 */
@Entity
@ToString
@Getter
@Setter
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String surName;

    protected Human(){

    }

    public Human(final String userName, final String surName) {
        this.userName = userName;
        this.surName = surName;
    }
}
