package at.spengergasse.plue.persistence.converter;

import at.spengergasse.plue.domain.StudentIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StudentIdentifierConverter implements AttributeConverter<StudentIdentifier, String> {
    @Override
    public String convertToDatabaseColumn(StudentIdentifier studentIdentifier) {
        return studentIdentifier == null ? null : studentIdentifier.value();
    }

    @Override
    public StudentIdentifier convertToEntityAttribute(String s) {
        return s == null ? null : new StudentIdentifier(s);
    }
}
