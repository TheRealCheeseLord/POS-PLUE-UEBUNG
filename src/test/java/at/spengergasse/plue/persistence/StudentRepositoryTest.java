package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.Person;
import at.spengergasse.plue.domain.Student;
import at.spengergasse.plue.domain.StudentIdentifier;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void can_save() {
       var person = Person.builder()
               .firstName("firstName")
               .lastName("lastName")
               .dateOfBirth(new Date())
               .build();

        var student = Student.builder()
                .person(person)
                .studentIdentifier(new StudentIdentifier("BAR210555"))
                .build();

       var saved = studentRepository.saveAndFlush(student);

       assertThat(saved.getId()).isNotNull();
    }
}
