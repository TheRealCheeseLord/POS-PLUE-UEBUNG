package at.spengergasse.plue.persistence.converter;

import at.spengergasse.plue.domain.TeacherIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TeacherIdentifierConverterTest {

    private TeacherIdentifierConverter converter;

    @BeforeEach
    void setup() {
        this.converter = new TeacherIdentifierConverter();
    }

    @Test
    public void can_map_to_db() {
        var teacherIdentifier = new TeacherIdentifier("UK");
        assertThat(converter.convertToDatabaseColumn(teacherIdentifier)).isEqualTo(teacherIdentifier.value());
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    public void can_map_from_db() {
        var teacherIdentifier = new TeacherIdentifier("UK");
        assertThat(converter.convertToEntityAttribute(teacherIdentifier.value())).isEqualTo(teacherIdentifier);
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }
}
