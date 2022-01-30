package one.digitalinnovation.refsapi.services;

import one.digitalinnovation.refsapi.dto.mapper.LinkMapper;
import one.digitalinnovation.refsapi.dto.request.LinkDTO;
import one.digitalinnovation.refsapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.refsapi.entities.Link;
import one.digitalinnovation.refsapi.repositories.LinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.refsapi.utils.LinkUtils.createFakeDTO;
import static one.digitalinnovation.refsapi.utils.LinkUtils.createFakeEntity;
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
