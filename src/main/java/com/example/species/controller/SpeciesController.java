package com.example.species.controller;

import com.example.species.model.Species;
import com.example.species.model.SpeciesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @PostMapping
    public ResponseEntity<Species> create(@Valid @RequestBody Species species) {
        return ResponseEntity.ok(speciesService.create(species));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Species> update(@PathVariable Integer id, @Valid @RequestBody Species species) {
        species.setId(id);
        return ResponseEntity.ok(speciesService.update(species));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        speciesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Species>> findAll() {
        return ResponseEntity.ok(speciesService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Species> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(speciesService.findById(id));
    }
}