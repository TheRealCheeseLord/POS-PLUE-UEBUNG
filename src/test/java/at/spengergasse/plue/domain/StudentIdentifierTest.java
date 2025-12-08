package at.spengergasse.plue.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudentIdentifierTest {

    @Test
    public void can_create_valid_student_identifier() {
        var studentIdentifier = new StudentIdentifier("BAR210555");
        assertThat(studentIdentifier).isNotNull();
    }

    @Test
    public void null_student_identifier_throws_error() {
        assertThatThrownBy(() -> new StudentIdentifier(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void invalid_student_identifier_throws_error() {
        assertThatThrownBy(() -> new StudentIdentifier("X"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("StudentIdentifier does not match valid pattern.");
    }
}
