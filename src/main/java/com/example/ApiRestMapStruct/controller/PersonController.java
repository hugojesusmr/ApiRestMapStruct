package com.example.ApiRestMapStruct.controller;

import com.example.ApiRestMapStruct.dto.PersonDto;
import com.example.ApiRestMapStruct.model.Person;
import com.example.ApiRestMapStruct.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;
    private Map<String, Object> response = new HashMap<>();

    @GetMapping
    private ResponseEntity<?> findAllPerson(){
        response.clear();
        response.put("people", personService.getAllPerson());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("person", personService.getPersonById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<?> savePerson(@Valid @RequestBody PersonDto personDto){
        response.clear();
        personService.savePerson(personDto);
        response.put("message","save person successfully");
        return  new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> updatePerson(@PathVariable Long id, PersonDto personDto){
        response.clear();
        personService.updatePerson(id, personDto);
        response.put("message", "update person successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePerson(@PathVariable Long id){
        response.clear();
        personService.deletePerson(id);
        response.put("message", "deleted person successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
