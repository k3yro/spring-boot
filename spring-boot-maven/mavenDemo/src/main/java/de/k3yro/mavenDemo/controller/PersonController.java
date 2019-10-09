package de.k3yro.mavenDemo.controller;

import de.k3yro.mavenDemo.entity.Person;
import de.k3yro.mavenDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getPerson(){

        List<Person> personList = personRepository.findAll();
        return  personList;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person savePerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/person",
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public Integer updatePerson(@RequestBody Person person){
        return personRepository.updatePerson(
                person.getId(),
                person.getVorname(),
                person.getNachname(),
                person.getGeburtsdatum()
        );
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/person2",
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public Person updatePerson2(@RequestBody Person person){
        Person updatePerson = personRepository.getOne(person.getId());

        updatePerson.setVorname(person.getVorname());
        updatePerson.setNachname(person.getNachname());
        updatePerson.setGeburtsdatum(person.getGeburtsdatum());

        return personRepository.saveAndFlush(updatePerson);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/person/{id}",
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public void deletePerson(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }
}
