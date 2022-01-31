package one.digitalinnovation.refsapi.mapper;

import one.digitalinnovation.refsapi.dto.mapper.LinkMapper;
import one.digitalinnovation.refsapi.dto.request.LinkDTO;
import one.digitalinnovation.refsapi.dto.request.QuoteDTO;
import one.digitalinnovation.refsapi.entities.Link;
import one.digitalinnovation.refsapi.entities.Quote;
import one.digitalinnovation.refsapi.utils.LinkUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LinkMapperTest {

    @Autowired
    private LinkMapper linkMapper;

    @Test
    void testGivenLinkDTOThenReturnLinkEntity() {
        LinkDTO linkDTO = LinkUtils.createFakeDTO();
        Link link = linkMapper.toModel(linkDTO);

        assertEquals(linkDTO.getAuthorship(), link.getAuthorship());
        assertEquals(linkDTO.getSource(), link.getSource());
        assertEquals(linkDTO.getUrl(), link.getUrl());
        assertEquals(linkDTO.getLanguage(), link.getLanguage());

        Quote quote = link.getQuotes().get(0);
        QuoteDTO quoteDTO = linkDTO.getQuotes().get(0);

        assertEquals(quoteDTO.getType(), quote.getType());
        assertEquals(quoteDTO.getQuote(), quote.getQuote());
    }

    @Test
    void testGivenLinkEntityThenReturnLinkDTO() {
        Link link = LinkUtils.createFakeEntity();
        LinkDTO linkDTO = linkMapper.toDTO(link);

        assertEquals(link.getAuthorship(), linkDTO.getAuthorship());
        assertEquals(link.getSource(), linkDTO.getSource());
        assertEquals(link.getUrl(), linkDTO.getUrl());
        assertEquals(link.getLanguage(), linkDTO.getLanguage());

        Quote quote = link.getQuotes().get(0);
        QuoteDTO quoteDTO = linkDTO.getQuotes().get(0);

        assertEquals(quote.getType(), quoteDTO.getType());
        assertEquals(quote.getQuote(), quoteDTO.getQuote());
    }
}
