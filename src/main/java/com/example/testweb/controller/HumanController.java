package com.example.testweb.controller;

import com.example.testweb.DAO.repository.HumanRepository;
import com.example.testweb.domain.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Roma Dziuba <rodzi@smile.fr>
 */
@RestController
@RequestMapping("/human")
public class HumanController {

    HumanRepository repository;

    @RequestMapping(value = "/", produces = "application/json")
    public Iterable<Human> getAllHumans(){

        return repository.findAll();
    }

    @Autowired
    public void setRepository(final HumanRepository repository) {
        this.repository = repository;
    }
}
