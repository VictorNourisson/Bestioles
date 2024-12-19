package com.example.species.model;

import com.example.species.dto.AnimalDto;
import com.example.species.mapper.AnimalMapper;
import com.example.species.repository.AnimalRepository;
import com.example.species.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    private AnimalMapper animalMapper;
    public Animal create(@Valid Animal animalToCreate) { return
            this.animalRepository.save(animalToCreate);
    }
    public Animal update(@Valid Animal updatedAnimal) { return
            this.animalRepository.save(updatedAnimal);
    }
    public Animal findById(Integer id) {
        return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Integer id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé ID: " + id);
        }
        animalRepository.deleteById(id);
    }

    public Optional<AnimalDto> findAnimalById(int id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isEmpty()) {
            throw new EntityNotFoundException("Animal introuvable avec l'ID : " + id);
        }
        return animal.map(animalMapper::toDto);
    }

    public List<AnimalDto> findAllAnimals() {
        return animalRepository.findAll()
                .stream()
                .map(animalMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<AnimalDto> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return animalRepository.findAll(pageable).map(animalMapper::toDto);
    }
}
