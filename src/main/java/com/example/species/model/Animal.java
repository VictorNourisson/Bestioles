package com.example.species.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String color;

    @Column(nullable = false)
    private String sex;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    @JsonIgnore
    @ManyToMany(mappedBy = "animals")
    private List<Person> owners;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", sex='" + sex + '\'' +
                ", species=" + species +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        return sex;
    }

    public Species getSpecies() {
        return species;
    }

    public List<Person> getOwners() {
        return owners;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }
}