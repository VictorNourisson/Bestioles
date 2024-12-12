package com.example.species.repository;

import com.example.species.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void deleteAllPersonWithoutAnimal() {
        em.createQuery("DELETE FROM Person p WHERE p.animals IS EMPTY").executeUpdate();
    }
}
