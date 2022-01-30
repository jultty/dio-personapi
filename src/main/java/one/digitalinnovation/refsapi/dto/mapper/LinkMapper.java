package one.digitalinnovation.refsapi.dto.mapper;

import one.digitalinnovation.refsapi.dto.request.LinkDTO;
import one.digitalinnovation.refsapi.entities.Link;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LinkMapper {

    @Mapping(target = "date", source = "date", dateFormat = "yyyy-MM-dd")
    Link toModel(LinkDTO dto);

    LinkDTO toDTO(Link dto);
}
