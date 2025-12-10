package at.spengergasse.plue.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "person_role")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonRole {
    @EmbeddedId
    private PersonRoleId id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK__person_role__2__person"))
    private Person person;

    public record PersonRoleId(@NotNull @GeneratedValue Long id) {}
}
