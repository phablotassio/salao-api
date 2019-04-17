package com.phablo.tassio.salao.api.model.mapper;

import com.phablo.tassio.salao.api.model.FisicPerson;
import com.phablo.tassio.salao.api.model.dto.FisicPersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FisicPersonMapper {

    @Mapping(source = "person.documentNumber", target = "documentNumber")
    @Mapping(source = "person.email", target = "email")
    @Mapping(source = "person.telephoneNumber", target = "telephoneNumber")
    FisicPersonDTO personToPersonDto(FisicPerson person);
    @Mapping(source = "documentNumber", target = "person.documentNumber")
    @Mapping(source = "email", target = "person.email")
    @Mapping(source = "telephoneNumber", target = "person.telephoneNumber")
    FisicPerson personDTOToFisicPerson(FisicPersonDTO personDTO);

}
