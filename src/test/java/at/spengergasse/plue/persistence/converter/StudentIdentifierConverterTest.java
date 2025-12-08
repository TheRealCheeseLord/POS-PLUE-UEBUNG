package at.spengergasse.plue.persistence.converter;

import at.spengergasse.plue.domain.StudentIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudentIdentifierConverterTest {

    private StudentIdentifierConverter converter;

    @BeforeEach
    void setup() {
        this.converter = new StudentIdentifierConverter();
    }

    @Test
    public void can_map_to_db() {
        var studentIdentifier = new StudentIdentifier("BAR210555");
        assertThat(converter.convertToDatabaseColumn(studentIdentifier)).isEqualTo(studentIdentifier.value());
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    public void can_map_from_db() {
        var studentIdentifier = new StudentIdentifier("BAR210555");
        assertThat(converter.convertToEntityAttribute(studentIdentifier.value())).isEqualTo(studentIdentifier);
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }
}
