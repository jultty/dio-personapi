package one.digitalinnovation.refsapi.repositories;

import one.digitalinnovation.refsapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
