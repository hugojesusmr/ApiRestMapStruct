package com.example.ApiRestMapStruct.mapper;

import com.example.ApiRestMapStruct.dto.PersonDto;
import com.example.ApiRestMapStruct.model.Person;
import org.mapstruct.*;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonDto personDto);
    PersonDto toDto(Person person);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PersonDto personDto, @MappingTarget Person person);
}
