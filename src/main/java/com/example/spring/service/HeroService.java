package com.example.spring.service;

import com.example.spring.entity.Hero;
import com.example.spring.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    public List<Hero> heroList() {
        return heroRepository.findAll();
    }

    public Hero getById(int id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero create(Hero hero) {
        return heroRepository.save(hero);
    }

    public Hero update(Hero hero){
        return heroRepository.save(hero);
    }

    public void delete(int id) {
        heroRepository.deleteById(id);
    }


}
