package one.digitalinnovation.refsapi.repositories;

import one.digitalinnovation.refsapi.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
