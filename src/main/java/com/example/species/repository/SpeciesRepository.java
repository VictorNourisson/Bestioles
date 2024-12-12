package com.example.species.repository;

import com.example.species.model.Species;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);
    
    List<Species> findByLatinNameContainingIgnoreCase(String latinName);

    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonName();

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE :commonName")
    List<Species> findAllByCommonNameSql(@Param("commonName") String commonName);

}
