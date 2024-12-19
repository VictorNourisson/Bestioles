package com.example.species.controller;

import com.example.species.dto.AnimalDto;
import com.example.species.model.Animal;
import com.example.species.model.AnimalService;
import com.example.species.model.Species;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<Animal> create(@Valid @RequestParam String specyId, @RequestBody Animal animal ) {
        return ResponseEntity.ok(animalService.findById(1));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Integer id, @Valid @RequestBody Animal animal) {
        animal.setId(id);
        return ResponseEntity.ok(animalService.update(animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<AnimalDto> getAllAnimals() {
        return animalService.findAllAnimals();
    }

    @GetMapping("/page")
    public Page<AnimalDto> getAnimalsPage(@RequestParam int page, @RequestParam int size) {
        return animalService.findPage(page, size);
    }

    @GetMapping("/{id}")
    public AnimalDto getAnimalById(@PathVariable int id) {
        return animalService.findAnimalById(id)
                .orElseThrow(() -> new RuntimeException("Animal non trouvé avec l'ID : " + id));
    }
}