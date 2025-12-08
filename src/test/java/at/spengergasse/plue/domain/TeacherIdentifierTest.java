package at.spengergasse.plue.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TeacherIdentifierTest {

    @Test
    public void can_create_valid_teacher_identifier() {
        var teacherIdentifier = new TeacherIdentifier("UK");
        assertThat(teacherIdentifier).isNotNull();
    }

    @Test
    public void null_teacher_identifier_throws_error() {
        assertThatThrownBy(() -> new TeacherIdentifier(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void invalid_teacher_identifier_throws_error() {
        assertThatThrownBy(() -> new TeacherIdentifier("X"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("TeacherIdentifier does not match valid pattern.");
    }
}
