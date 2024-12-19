package com.example.species.model;

import com.example.species.repository.AnimalRepository;
import com.example.species.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;

    public Species create(@Valid Species speciesToCreate) {
        return this.speciesRepository.save(speciesToCreate);
    }

    public Species update(@Valid Species updatedSpecies) {
        return this.speciesRepository.save(updatedSpecies);
    }

    public Species findById(Integer id) {
        return this.speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Integer id) {
        if (!speciesRepository.existsById(id)) {
            throw new EntityNotFoundException("Species non trouvé ID: " + id);
        }
        speciesRepository.deleteById(id);
    }

    public List<Species> getAll() {
        return this.speciesRepository.findAll();
    }
}
