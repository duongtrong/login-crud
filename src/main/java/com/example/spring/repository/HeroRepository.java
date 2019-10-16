package com.example.spring.repository;

import com.example.spring.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository {
    Hero getHeroById(int id);

    Hero getHeroByName(String name);

    Hero save(Hero hero);

    List<Hero> findAll();

    void deleteHero(Hero hero);

    void deleteById(int id);
}
