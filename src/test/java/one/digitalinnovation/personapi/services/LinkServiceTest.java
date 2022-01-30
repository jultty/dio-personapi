package one.digitalinnovation.personapi.services;

import one.digitalinnovation.personapi.dto.mapper.LinkMapper;
import one.digitalinnovation.personapi.dto.request.LinkDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entities.Link;
import one.digitalinnovation.personapi.repositories.LinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.LinkUtils.createFakeDTO;
import static one.digitalinnovation.personapi.utils.LinkUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LinkServiceTest {

    @Mock
    private LinkRepository linkRepository;

    @Mock
    private LinkMapper linkMapper;

    @InjectMocks
    private LinkService linkService;

    @Test
    void testGivenLinkDTOThenReturnSuccessSavedMessage() {
        LinkDTO linkDTO = createFakeDTO();
        Link expectedSavedLink = createFakeEntity();

        when(linkMapper.toModel(linkDTO)).thenReturn(expectedSavedLink);
        when(linkRepository.save(any(Link.class))).thenReturn(expectedSavedLink);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedLink.getId());
        MessageResponseDTO successMessage = linkService.create(linkDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long saveLinkId) {
        return MessageResponseDTO.builder()
                .message("Link entry successfully created with ID " + saveLinkId)
                .build();
    }

}
