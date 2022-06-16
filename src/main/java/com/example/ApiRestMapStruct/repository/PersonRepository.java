package com.example.ApiRestMapStruct.repository;

import com.example.ApiRestMapStruct.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
