package at.spengergasse.plue.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
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

@Embeddable
@DiscriminatorValue("MS")
public class MakerSpaceRoom extends Room {
    private String specialEquipment;
}
