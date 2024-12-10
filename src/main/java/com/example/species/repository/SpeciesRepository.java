package com.example.species.repository;

import com.example.species.model.Species;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);
    
    List<Species> findByLatinNameContainingIgnoreCase(String latinName);
}
