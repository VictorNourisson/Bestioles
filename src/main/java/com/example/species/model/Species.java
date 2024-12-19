package com.example.species.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "common_name", nullable = false, length = 50)
    private String commonName;

    @Column(name = "latin_name", nullable = false, length = 200)
    private String latinName;

    @JsonIgnore
    @OneToMany(mappedBy = "species")
    private List<Animal> animals;

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", commonName='" + commonName + '\'' +
                ", latinName='" + latinName + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Integer getId() {
        return id;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}