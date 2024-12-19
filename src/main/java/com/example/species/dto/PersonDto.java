package com.example.species.dto;

import java.util.List;

public class PersonDto {
    private Integer id;
    private String name; // Contient NOM (en majuscule) + Prénom
    private Integer age;
    private List<String> animals; // Tableau des noms d'animaux

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getAnimals() {
        return animals;
    }

    public void setAnimals(List<String> animals) {
        this.animals = animals;
    }
} 