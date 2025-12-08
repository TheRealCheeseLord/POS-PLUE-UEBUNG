package at.spengergasse.plue.persistence.converter;

import at.spengergasse.plue.domain.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TeacherIdentifierConverter implements AttributeConverter<TeacherIdentifier, String> {
    @Override
    public String convertToDatabaseColumn(TeacherIdentifier teacherIdentifier) {
        return teacherIdentifier == null ? null : teacherIdentifier.value();
    }

    @Override
    public TeacherIdentifier convertToEntityAttribute(String s) {
        return s == null ? null : new TeacherIdentifier(s);
    }
}
