package at.spengergasse.plue.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "event_time_slot")
public class EventTimeSlot {
    @EmbeddedId
    private EventTimeSlotId id;
    private String slotTitle;
    private String slotDescription;
    // "day", "from" & "to" are all reserved keywords; therefor name change
    @Column(nullable = false, name = "`day`")
    private Date day;
    @Column(nullable = false, name = "`from`")
    private Time from;
    @Column(nullable = false, name = "`to`")
    private Time to;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event_time_slot_id", foreignKey = @ForeignKey(name = "FK__student__2__event_time_slot"))
    @Builder.Default
    private Set<Student> students = new HashSet<>();
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event_time_slot_id", foreignKey = @ForeignKey(name = "FK__teacher__2__event_time_slot"))
    @Builder.Default
    private Set<Teacher> teachers = new HashSet<>();

    public record EventTimeSlotId(@NotNull @GeneratedValue Long id) {}
}
