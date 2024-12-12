package com.example.species.repository;

import com.example.species.model.Animal;
import com.example.species.model.Species;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(Species species);
    
    List<Animal> findByColorIn(List<String> colors);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    Long countAnimalsBySex(@Param("sex") String sex);

    @Query("SELECT COUNT(p) > 0 FROM Person p JOIN p.animals a WHERE a = :animal")
    boolean existsAnimalOwnedByAnyPerson(@Param("animal") Animal animal);

}
