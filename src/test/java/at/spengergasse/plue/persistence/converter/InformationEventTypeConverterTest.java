package at.spengergasse.plue.persistence.converter;

import at.spengergasse.plue.domain.InformationEventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InformationEventTypeConverterTest {

    private InformationEventTypeConverter converter;

    @BeforeEach
    void setup() {
        this.converter = new InformationEventTypeConverter();
    }

    @Test
    public void can_map_valid_to_db() {
        assertThat(this.converter.convertToDatabaseColumn(InformationEventType.GUIDED_TOUR)).isEqualTo('G');
        assertThat(this.converter.convertToDatabaseColumn(InformationEventType.MAKER_SPACE)).isEqualTo('M');
        assertThat(this.converter.convertToDatabaseColumn(InformationEventType.PRESENTATION)).isEqualTo('P');
        assertThat(this.converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    public void can_map_valid_from_db() {
        assertThat(this.converter.convertToEntityAttribute('G')).isEqualTo(InformationEventType.GUIDED_TOUR);
        assertThat(this.converter.convertToEntityAttribute('M')).isEqualTo(InformationEventType.MAKER_SPACE);
        assertThat(this.converter.convertToEntityAttribute('P')).isEqualTo(InformationEventType.PRESENTATION);
        assertThat(this.converter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    public void invalid_from_db_throws_exception() {
        assertThatThrownBy(() -> this.converter.convertToEntityAttribute('X'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("DQE:");
    }
}
