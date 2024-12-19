package com.example.species.controller;

import com.example.species.dto.PersonDto;
import com.example.species.model.Person;
import com.example.species.model.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person) {
        return ResponseEntity.ok(personService.create(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Integer id, @Valid @RequestBody Person person) {
        person.setId(id);
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.findAllPersons();
    }

    @GetMapping("/page")
    public Page<PersonDto> getPersonsPage(@RequestParam int page, @RequestParam int size) {
        return personService.findPage(page, size);
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable int id) {
        return personService.findPersonById(id)
                .orElseThrow(() -> new RuntimeException("Personne non trouvée avec l'ID : " + id));
    }

}
