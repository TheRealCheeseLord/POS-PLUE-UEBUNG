package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.Person;
import at.spengergasse.plue.domain.Teacher;
import at.spengergasse.plue.domain.TeacherIdentifier;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void can_save() {
       var person = Person.builder()
               .firstName("firstName")
               .lastName("lastName")
               .dateOfBirth(new Date())
               .build();

        var teacher = Teacher.builder()
                .person(person)
                .teacherIdentifier(new TeacherIdentifier("UK"))
                .build();

       var saved = teacherRepository.saveAndFlush(teacher);

       assertThat(saved.getId()).isNotNull();
    }
}
