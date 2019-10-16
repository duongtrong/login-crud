package com.example.spring.service;

import com.example.spring.entity.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> heroList();

    Hero getById(int id);

    Hero create(Hero hero);

    Hero update(Hero hero);

    void delete(int id);
}
