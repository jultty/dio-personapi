package one.digitalinnovation.personapi.dto.mapper;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "date", source = "date", dateFormat = "yyyy-MM-dd")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
