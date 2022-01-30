package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.mapper.PersonMapper;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.QuoteDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.entities.Quote;
import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getAuthor(), person.getAuthor());
        assertEquals(personDTO.getSource(), person.getSource());
        assertEquals(personDTO.getUrl(), person.getUrl());
        assertEquals(personDTO.getLanguage(), person.getLanguage());

        Quote quote = person.getQuotes().get(0);
        QuoteDTO quoteDTO = personDTO.getQuotes().get(0);

        assertEquals(quoteDTO.getType(), quote.getType());
        assertEquals(quoteDTO.getQuote(), quote.getQuote());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getAuthor(), personDTO.getAuthor());
        assertEquals(person.getSource(), personDTO.getSource());
        assertEquals(person.getUrl(), personDTO.getUrl());
        assertEquals(person.getLanguage(), personDTO.getLanguage());

        Quote quote = person.getQuotes().get(0);
        QuoteDTO quoteDTO = personDTO.getQuotes().get(0);

        assertEquals(quote.getType(), quoteDTO.getType());
        assertEquals(quote.getQuote(), quoteDTO.getQuote());
    }
}
