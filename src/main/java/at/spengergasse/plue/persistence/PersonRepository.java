package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Person.PersonId> {
}
