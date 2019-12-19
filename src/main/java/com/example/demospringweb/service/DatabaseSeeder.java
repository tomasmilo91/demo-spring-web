package com.example.demospringweb.service;

import com.example.demospringweb.dao.PersonRepository;
import com.example.demospringweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private PersonRepository personRepository;


    @Autowired
    public DatabaseSeeder (PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Person> persons= new ArrayList<>();

        persons.add(new Person("Kandidate First",39, "0904567888","emailfirst@email.cz"));
        persons.add(new Person("Employee First",39, "0904567888","emailemployeefirst@email.cz", 3000));
        persons.add(new Person("Kandidate Second",31, "0907767888","emailsecond@email.cz"));
        persons.add(new Person("Employee First",39, "0909867888","emailemployeesecond@email.cz", 1600));


        personRepository.saveAll(persons);

    }
}
