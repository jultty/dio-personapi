package one.digitalinnovation.refsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LinkNotFoundException extends Exception {

    public LinkNotFoundException(Long id) {
        super(String.format("Link with ID %s not found!", id));
    }
}
