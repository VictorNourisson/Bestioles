package com.example.species.mapper;

import com.example.species.dto.PersonDto;
import com.example.species.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonMapper {

    public PersonDto toDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setName(person.getLastname().toUpperCase() + " " + person.getFirstname());
        dto.setAge(person.getAge());
        dto.setAnimals(
                List.of(person.getAnimals().stream()
                        .map(animal -> animal.getName() + " (" + animal.getSpecies() + ")")
                        .toArray(String[]::new))
        );
        return dto;
    }
}