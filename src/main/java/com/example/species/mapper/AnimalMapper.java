package com.example.species.mapper;

import com.example.species.dto.AnimalDto;
import com.example.species.model.Animal;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AnimalMapper {

    public AnimalDto toDto(Animal animal) {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setColor(animal.getColor());
        dto.setSpecies(animal.getSpecies().getCommonName());
        dto.setPersons(
                animal.getOwners().stream()
                        .map(owner -> owner.getFirstname() + " " + owner.getLastname())
                        .collect(Collectors.joining(", "))
        );
        return dto;
    }
}