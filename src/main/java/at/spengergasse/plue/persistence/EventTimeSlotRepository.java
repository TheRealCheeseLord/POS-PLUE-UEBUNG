package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.EventTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTimeSlotRepository extends JpaRepository<EventTimeSlot, EventTimeSlot.EventTimeSlotId> {
}
