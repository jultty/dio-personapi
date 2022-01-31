package one.digitalinnovation.refsapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.refsapi.dto.mapper.BookMapper;
import one.digitalinnovation.refsapi.dto.request.BookDTO;
import one.digitalinnovation.refsapi.dto.request.LinkDTO;
import one.digitalinnovation.refsapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.refsapi.entities.Book;
import one.digitalinnovation.refsapi.exception.BookNotFoundException;
import one.digitalinnovation.refsapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = verifyIfExists(id);

        return bookMapper.toDTO(book);
    }

    public List<BookDTO> listAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, BookDTO bookDTO) throws BookNotFoundException {
        verifyIfExists(id);

        Book updatedBook = bookMapper.toModel(bookDTO);
        Book savedBook = bookRepository.save(updatedBook);

        return createMessageResponse("Book entry successfully updated with ID", savedBook.getId());
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book book = bookMapper.toModel(bookDTO);
        Book savedBook = bookRepository.save(book);

        return createMessageResponse("Book entry successfully" +
                " created with ID ", savedBook.getId());
    }

    public void delete(Long id) throws BookNotFoundException {
        verifyIfExists(id);
        bookRepository.deleteById(id);
    }

    private Book verifyIfExists(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder().message(s + id2).build();
    }

}
