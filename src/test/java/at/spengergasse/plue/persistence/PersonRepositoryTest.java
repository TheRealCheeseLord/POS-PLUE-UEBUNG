package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.Person;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void can_save() {
       var person = Person.builder()
               .firstName("firstName")
               .lastName("lastName")
               .dateOfBirth(new Date())
               .build();

       var saved = personRepository.saveAndFlush(person);

       assertThat(saved.getId()).isNotNull();
    }

    @Test
    public void can_find_by_lastname_schmidt() {
        var person = Person.builder()
                .firstName("firstName")
                .lastName("Schmidt")
                .dateOfBirth(new Date())
                .build();

        personRepository.saveAndFlush(person);

        var schmidts = personRepository.findAllByLastNameSchmidt();

        assertThat(schmidts).isNotEmpty();
    }
}
