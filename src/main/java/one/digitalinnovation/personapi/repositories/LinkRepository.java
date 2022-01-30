package one.digitalinnovation.personapi.repositories;

import one.digitalinnovation.personapi.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
