package at.spengergasse.plue.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder

@Embeddable
@DiscriminatorValue("P")
public class PresentationRoom extends Room {}
