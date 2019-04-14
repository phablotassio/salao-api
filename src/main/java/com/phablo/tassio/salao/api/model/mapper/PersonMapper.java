package com.phablo.tassio.salao.api.model.mapper;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO personToPersonDto(Person person);
    Person personDTOToPerson(PersonDTO personDTO);

}
