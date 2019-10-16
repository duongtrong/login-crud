package com.example.spring.service.serviceimpl;

import com.example.spring.entity.Hero;
import com.example.spring.repository.HeroRepository;
import com.example.spring.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> heroList() {
        return heroRepository.findAll();
    }

    public Hero getById(int id) {
        return heroRepository.getHeroById(id);
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
