package com.example.species;

import com.example.species.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.species.model.Animal;
import com.example.species.model.Species;
import com.example.species.model.Person;
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
        /*System.out.println("=== Test du PersonRepository ===");
        
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

		System.out.println("Nombre de personnes après : " + personRepository.count());*/

		/*Species chatByName = speciesRepository.findFirstByCommonName("Chat");
		System.out.println("Première espèce trouvée avec le nom 'Chat': " + chatByName);

		List<Species> speciesList = speciesRepository.findByLatinNameContainingIgnoreCase("fel");
		System.out.println("Espèces contenant 'fel' dans leur nom latin:");
		speciesList.forEach(System.out::println);

        List<Person> personsByName = personRepository.findByLastnameAndFirstname("Dupont", "Jean");
        System.out.println("Personnes avec le nom 'Dupont' ou le prénom 'Jean':");
        personsByName.forEach(System.out::println);

        List<Person> personsByAge = personRepository.findByAgeGreaterThanEqual(30);
        System.out.println("Personnes âgées de 30 ans ou plus:");
        personsByAge.forEach(System.out::println);

        Species chatById = speciesRepository.findById(1).orElse(null);
        if (chatById != null) {
            List<Animal> chatAnimals = animalRepository.findBySpecies(chatById);
            System.out.println("Animaux de l'espèce " + chatById.getCommonName() + ":");
            chatAnimals.forEach(System.out::println);
        }

        List<String> colors = Arrays.asList("Noir", "Blanc", "Roux");
        List<Animal> coloredAnimals = animalRepository.findByColorIn(colors);
        System.out.println("Animaux de couleur Noir, Blanc ou Roux:");
        coloredAnimals.forEach(System.out::println);*/

        /*System.out.println(speciesRepository.findAllOrderedByCommonName());
        System.out.println(speciesRepository.findAllByCommonNameSql("test"));
        System.out.println(personRepository.findAllByAgeBetween(7, 45));
        Animal animal = animalRepository.findById(1).orElse(null);
        System.out.println(personRepository.findPersonByAnimals(animal));
        System.out.println(animalRepository.countAnimalsBySex("M"));
        System.out.println(animalRepository.existsAnimalOwnedByAnyPerson(animal));*/

       System.out.println("Delete persons without animals : " + this.personRepository.findAll());
        this.personRepository.deleteAllPersonWithoutAnimal();
        System.out.println("Delete persons without animals : " + this.personRepository.findAll());
        System.out.println("Create new Person : " + this.personRepository.generateXNewPerson(5));
    }
}
