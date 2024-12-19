package com.example.species.model;

import com.example.species.dto.PersonDto;
import com.example.species.exception.EntityToCreateHasAnIdException;
import com.example.species.exception.EntityToUpdateHasNoIdException;
import com.example.species.mapper.PersonMapper;
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
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;
    public Person create(@Valid Person personToCreate) {
        if (personToCreate.getId() != null) {
            throw new EntityToCreateHasAnIdException("L'entité à créer ne doit pas avoir d'ID.");
        }
        return this.personRepository.save(personToCreate);
    }
    public Person update(@Valid Person updatedPerson) {
        if (updatedPerson.getId() == null) {
            throw new EntityToUpdateHasNoIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        if (!this.personRepository.existsById(updatedPerson.getId())) {
            throw new EntityNotFoundException("L'entité avec l'ID " + updatedPerson.getId() + " n'existe pas.");
        }
        return this.personRepository.save(updatedPerson);
    }
    public Person findById(Integer id) {
        return this.personRepository.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("L'entité avec l'ID " + id + " n'existe pas."));
    }

    public void delete(Integer id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("L'entité avec l'ID " + id + " n'existe pas.");
        }
        personRepository.deleteById(id);
    }
    public Optional<PersonDto> findPersonById(int id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new EntityNotFoundException("Personne introuvable avec l'ID : " + id);
        }
        return person.map(personMapper::toDto);
    }

    public List<PersonDto> findAllPersons() {
        return personRepository.findAll()
                .stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<PersonDto> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAll(pageable).map(personMapper::toDto);
    }

}
