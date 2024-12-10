package com.example.species.repository;

import com.example.species.model.Animal;
import com.example.species.model.Species;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(Species species);
    
    List<Animal> findByColorIn(List<String> colors);
}
