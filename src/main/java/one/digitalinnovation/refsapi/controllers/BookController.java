package one.digitalinnovation.refsapi.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.refsapi.dto.request.BookDTO;
import one.digitalinnovation.refsapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.refsapi.exception.BookNotFoundException;
import one.digitalinnovation.refsapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    @GetMapping
    public List<BookDTO> listAll() { return bookService.listAll(); }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) throws BookNotFoundException {
        return bookService.update(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws BookNotFoundException {
        bookService.delete(id);
    }

}
