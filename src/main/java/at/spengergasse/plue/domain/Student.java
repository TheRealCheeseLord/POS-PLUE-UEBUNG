package at.spengergasse.plue.domain;

import at.spengergasse.plue.persistence.converter.StudentIdentifierConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@Entity
@Table(name = "student")
public class Student extends PersonRole {
    @Column(nullable = false, unique = true)
    @Convert(converter = StudentIdentifierConverter.class)
    private StudentIdentifier studentIdentifier;
}
