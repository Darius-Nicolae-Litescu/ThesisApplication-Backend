package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}