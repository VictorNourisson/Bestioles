package com.example.species.repository;

import com.example.species.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void deleteAllPersonWithoutAnimal() {
        em.createNativeQuery( "DELETE FROM person WHERE id IN (SELECT p.id FROM person p LEFT JOIN person_animals pa ON p.id = pa.person_id WHERE pa.person_id IS NULL)").executeUpdate();
    }
    @Transactional
    @Override
    public List<Person> generateXNewPerson(Integer x) {
        List<Person> newPerson = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            Person p = new Person();
            p.setFirstname("John"+i);
            p.setLastname("Doe"+i);
            p.setAge(i);
            em.persist(p);
            newPerson.add(p);
        }
        return newPerson;
    }
}
