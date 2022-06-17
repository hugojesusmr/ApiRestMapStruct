package com.example.ApiRestMapStruct.service;

import com.example.ApiRestMapStruct.dto.PersonDto;
import com.example.ApiRestMapStruct.model.Person;

import java.util.List;

public interface PersonService {
    PersonDto getPersonById(Long id);
    List<Person> getAllPerson();
    void savePerson(PersonDto person);
    void updatePerson(Long id, PersonDto person);
    void deletePerson(Long id);
}

