package com.example.testweb.DAO.repository;

import com.example.testweb.domain.Human;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface HumanRepository extends CrudRepository<Human, Long> {
    List<Human> findBySurName(String surName);
}
