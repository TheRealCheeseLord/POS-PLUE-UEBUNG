package at.spengergasse.plue.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "person")
public class Person {
    @EmbeddedId
    private PersonId id;
    @Version
    private Integer version;
    @NotNull
    @Column(nullable = false)
    private String firstName;
    @NotNull
    @Column(nullable = false)
    private String lastName;
    @NotNull
    @Column(nullable = false)
    private Date dateOfBirth;

    public record PersonId(@NotNull @GeneratedValue Long id) {}
}
