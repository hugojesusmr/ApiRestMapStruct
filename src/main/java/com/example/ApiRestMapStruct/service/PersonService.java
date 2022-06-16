package com.example.ApiRestMapStruct.service;

import com.example.ApiRestMapStruct.model.Person;

import java.util.List;

public interface PersonService {
    Person getPersonById(Long id);
    List<Person> getAllPerson();
    void savePerson(Person person);
    void updatePerson(Long id, Person person);
    void deletePerson(Long id);
}

