package com.example.species.repository;

import com.example.species.model.Person;

import java.util.List;

public interface PersonRepositoryCustom {
    void deleteAllPersonWithoutAnimal();
    List<Person> generateXNewPerson(Integer x);
}
