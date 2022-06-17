package com.example.ApiRestMapStruct.service.impl;

import com.example.ApiRestMapStruct.dto.PersonDto;
import com.example.ApiRestMapStruct.exception.NotFoundException;
import com.example.ApiRestMapStruct.mapper.PersonMapper;
import com.example.ApiRestMapStruct.model.Person;
import com.example.ApiRestMapStruct.repository.PersonRepository;
import com.example.ApiRestMapStruct.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;
    @Transactional
    @Override
    public PersonDto getPersonById(Long id) {
        return personMapper.toDto(personRepository.findById(id)
                .orElseThrow(
                        ()->new NotFoundException("Person Not Found")));
    }
    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    @Transactional
    @Override
    public void savePerson(PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        personRepository.save(person);
    }
    @Transactional
    @Override
    public void updatePerson(Long id, PersonDto personDto) {
    Person person = personRepository.findById(id).orElseThrow(
            ()-> new NotFoundException("Person not Found")
    );
        personMapper.updateEntity(personDto,person);
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id)
                                        .orElseThrow(()-> new NotFoundException("Person Not Found"));
        personRepository.deleteById(id);
    }
}





