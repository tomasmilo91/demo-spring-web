package com.example.demospringweb.controller;

import com.example.demospringweb.model.Person;
import com.example.demospringweb.dao.PersonRepository;
import com.example.demospringweb.model.PersonType;
import io.micrometer.core.lang.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController  //return list of objects
@RequestMapping(value = "/persons")
public class PersonController {

    PersonRepository personRepository;
    private static final Logger LOG = LoggerFactory.getLogger(Person.class);

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Person> getAll(){
        LOG.info("Getall user data");
        return personRepository.findAll();

    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public List<Person> create(@RequestBody Person person){
        personRepository.save(person);
        LOG.info("Created user data");
        return personRepository.findAll();

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public List<Person> delete(@PathVariable long id){
        personRepository.deleteById(id);
        LOG.info("Delete user data");
        return personRepository.findAll();
    }


    @RequestMapping(value="/edit/{id}", method = RequestMethod.PUT)
    public List<Person> edit(@PathVariable long id,@RequestBody Person personP){
        Optional<Person> foundedP = personRepository.findById(id);

        if(!foundedP.isEmpty()){
            foundedP.get().setName(personP.getName());
            foundedP.get().setAge(personP.getAge());
            foundedP.get().setTelephone(personP.getTelephone());
            foundedP.get().setEmail(personP.getEmail());

            if(personP.getSalary()==0){
                 foundedP.get().setPersonType(PersonType.KAN);
            }
            else{
                foundedP.get().setPersonType(PersonType.EMP);
                foundedP.get().setSalary(personP.getSalary());
            }
        }
        LOG.info("Edit user data");
        personRepository.saveAll(personRepository.findAll());
        return personRepository.findAll();
    }


}
