package one.digitalinnovation.refsapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.refsapi.dto.mapper.LinkMapper;
import one.digitalinnovation.refsapi.dto.request.LinkDTO;
import one.digitalinnovation.refsapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.refsapi.entities.Link;
import one.digitalinnovation.refsapi.exception.LinkNotFoundException;
import one.digitalinnovation.refsapi.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LinkService {

    private final LinkRepository linkRepository;

    private final LinkMapper linkMapper;

    public MessageResponseDTO create(LinkDTO linkDTO) {
        Link link = linkMapper.toModel(linkDTO);
        Link savedLink = linkRepository.save(link);

        return createMessageResponse("Link entry successfully created with ID ", savedLink.getId());
    }

    public LinkDTO findById(Long id) throws LinkNotFoundException {
        Link link = verifyIfExists(id);

        return linkMapper.toDTO(link);
    }

    public List<LinkDTO> listAll() {
        List<Link> people = linkRepository.findAll();
        return people.stream()
                .map(linkMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, LinkDTO linkDTO) throws LinkNotFoundException {
        verifyIfExists(id);

        Link updatedLink = linkMapper.toModel(linkDTO);
        Link savedLink = linkRepository.save(updatedLink);

        return createMessageResponse("Link entry successfully updated with ID ", savedLink.getId());
    }

    public void delete(Long id) throws LinkNotFoundException {
        verifyIfExists(id);
        linkRepository.deleteById(id);
    }

    private Link verifyIfExists(Long id) throws LinkNotFoundException {
        return linkRepository.findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
