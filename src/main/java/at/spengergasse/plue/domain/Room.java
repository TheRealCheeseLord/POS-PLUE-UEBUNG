package at.spengergasse.plue.domain;

import jakarta.persistence.*;
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
@DiscriminatorColumn(
        name = "room_type",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("R")
public class Room {
    @Column(nullable = false)
    private String building;
    @Column(nullable = false)
    private String level;
    @Column(nullable = false)
    private String roomNo;
    private String description;
    @Column(nullable = false)
    private int numberOfDesks;
    @Column(nullable = false)
    private int numberOfSeats;
}
