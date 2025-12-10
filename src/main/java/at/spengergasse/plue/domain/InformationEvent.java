package at.spengergasse.plue.domain;

import at.spengergasse.plue.persistence.converter.InformationEventTypeConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "information_event")
public class InformationEvent {
    @EmbeddedId
    private InformationEventId id;
    @Version
    private Integer version;
    @Convert(converter = InformationEventTypeConverter.class)
    private InformationEventType eventType;
    @Column(nullable = false)
    private String name;
    private String description;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "description", column = @Column(name = "room_description"))
    })
    private Room room;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true
    )
    @JoinColumn(name = "information_event_id", foreignKey = @ForeignKey(name = "FK__slot__2__information_event"))
    @Builder.Default
    private Set<EventTimeSlot> slots = new HashSet<>();
    // ka ob das unten stimmt; domain model ist von einem idioten gemacht
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "information_event_id", foreignKey = @ForeignKey(name = "FK__teacher__2__information_event"))
    @Builder.Default
    private Set<Teacher> teachers = new HashSet<>();
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "information_event_id", foreignKey = @ForeignKey(name = "FK__student__2__information_event"))
    @Builder.Default
    private Set<Student> students = new HashSet<>();

    public record InformationEventId(@NotNull @GeneratedValue Long id) {}
}
