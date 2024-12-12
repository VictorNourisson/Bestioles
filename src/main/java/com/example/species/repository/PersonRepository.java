package com.example.species.repository;

import com.example.species.model.Animal;
import com.example.species.model.Person;
import com.example.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {

    List<Person> findByLastnameAndFirstname(String lastname, String firstname);

    List<Person> findByAgeGreaterThanEqual(int age);

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findAllByAgeBetween(@Param("ageMin") int ageMin, @Param("ageMax") int ageMax);

    @Query("SELECT p FROM Person p WHERE :animal MEMBER OF p.animals")
    List<Person> findPersonByAnimals(@Param("animal") Animal animal);
}
