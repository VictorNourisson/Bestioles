package com.example.species.repository;

import com.example.species.model.Person;
import com.example.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByLastnameAndFirstname(String lastname, String firstname);

    List<Person> findByAgeGreaterThanEqual(int age);
}
