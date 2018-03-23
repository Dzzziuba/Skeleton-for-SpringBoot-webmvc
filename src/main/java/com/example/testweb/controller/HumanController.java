package com.example.testweb.controller;

import com.example.testweb.DAO.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roma Dziuba <rodzi@smile.fr>
 */
@Controller
@RequestMapping("/human")
public class HumanController {

    private HumanRepository repository;

    @RequestMapping(value = "/")
    public String getAllHumans(ModelMap model) {
        model.put("humans", repository.findAll());
        return "human_list";
    }

    @Autowired
    public void setRepository(final HumanRepository repository) {
        this.repository = repository;
    }
}
