package com.example.species;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.species.repository.PersonRepository;
import com.example.species.model.Animal;
import com.example.species.model.Species;
import com.example.species.model.Person;
import com.example.species.repository.AnimalRepository;
import com.example.species.repository.SpeciesRepository;
import com.example.species.repository.PersonRepository;


@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private SpeciesRepository speciesRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Test du PersonRepository ===");
        
        System.out.println("Liste initiale des personnes :");
        personRepository.findAll().forEach(System.out::println);

        Species newEspece = new Species();
        newEspece.setCommonName("test");
        newEspece.setLatinName("ok");

		Animal newAnimal = new Animal();
		newAnimal.setName("Rex");
		newAnimal.setColor("Noir");
		newAnimal.setSex("M");
        newAnimal.setSpecies(newEspece);

        System.out.println(animalRepository.findById(1));

		System.out.println("Nombre de personnes avant : " + personRepository.count());
    
		personRepository.deleteById(1);

		System.out.println("Nombre de personnes après : " + personRepository.count());

    }
}
