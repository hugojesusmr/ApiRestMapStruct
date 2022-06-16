package com.example.ApiRestMapStruct.service.impl;

import com.example.ApiRestMapStruct.model.Person;
import com.example.ApiRestMapStruct.repository.PersonRepository;
import com.example.ApiRestMapStruct.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);

    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
    Person p = personRepository.findById(id).orElseThrow(
            ()-> new NoSuchElementException("Person not Found")
    );
        p.setName(person.getName());
        p.setLastName(person.getLastName());
        personRepository.save(p);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}





