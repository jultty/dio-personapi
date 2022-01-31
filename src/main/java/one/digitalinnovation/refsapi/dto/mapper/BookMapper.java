package one.digitalinnovation.refsapi.dto.mapper;

import one.digitalinnovation.refsapi.dto.request.BookDTO;
import one.digitalinnovation.refsapi.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "date", source = "date", dateFormat = "yyyy-MM-dd")
    Book toModel(BookDTO dto);

    BookDTO toDTO(Book dto);
}
