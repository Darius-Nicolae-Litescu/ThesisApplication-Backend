package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}