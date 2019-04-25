package com.phablo.tassio.salao.api.mapper;

import com.phablo.tassio.salao.api.model.Employee;
import com.phablo.tassio.salao.api.model.dto.EmployeeRequestDTO;
import com.phablo.tassio.salao.api.model.dto.EmployeeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    @Mapping(source = "juridicalPerson.fantasyName", target = "nameJuridicalPerson")
    @Mapping(source = "role.description", target = "nameRole")
    @Mapping(source = "fisicPerson.person.documentNumber", target = "documentNumber")
    @Mapping(source = "fisicPerson.person.email", target = "email")
    @Mapping(source = "fisicPerson.person.telephoneNumber", target = "telephoneNumber")
    @Mapping(source = "fisicPerson.birthdate", target = "birthdate")
    @Mapping(source = "fisicPerson.fullName", target = "fullName")
    @Mapping(source = "fisicPerson.nickName", target = "nickName")
    @Mapping(source = "fisicPerson.sexType", target = "sexType")
    EmployeeResponseDTO employeeToEmployeeResponseDto(Employee employee);


    @Mapping(source = "documentNumber", target = "fisicPerson.person.documentNumber")
    @Mapping(source = "email", target = "fisicPerson.person.email")
    @Mapping(source = "telephoneNumber", target = "fisicPerson.person.telephoneNumber")
    @Mapping(source = "birthdate", target = "fisicPerson.birthdate")
    @Mapping(source = "fullName", target = "fisicPerson.fullName")
    @Mapping(source = "nickName", target = "fisicPerson.nickName")
    @Mapping(source = "sexType", target = "fisicPerson.sexType")
    Employee employeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTODTO);

}
