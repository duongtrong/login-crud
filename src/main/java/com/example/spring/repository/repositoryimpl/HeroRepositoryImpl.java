package com.example.spring.repository.repositoryimpl;

import com.example.spring.entity.Hero;
import com.example.spring.repository.HeroRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {

    private EntityManager entityManager;

    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Hero getHeroById(int id) {
        return entityManager.find(Hero.class, id);
    }

    @Override
    public Hero getHeroByName(String name) {
        return entityManager.find(Hero.class, name);
    }

    @Override
    public Hero save(Hero hero) {
        return entityManager.find(Hero.class, hero);
    }

    @Override
    public List<Hero> findAll() {
        return null;
    }

    @Override
    public void deleteHero(Hero hero) {
        if (entityManager.contains(hero)) {
            entityManager.remove(hero);
        } else {
            entityManager.merge(hero);
        }
    }

    @Override
    public void deleteById(int id) {
        if (entityManager.contains(id)) {
            entityManager.remove(id);
        } else {
            entityManager.merge(id);
        }
    }
}
