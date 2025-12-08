package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Person.PersonId> {

    @Query("SELECT p FROM Person p WHERE p.lastName ILIKE 'Schmidt'")
    List<Person> findAllByLastNameSchmidt();
}
