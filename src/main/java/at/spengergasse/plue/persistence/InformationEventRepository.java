package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.InformationEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationEventRepository extends JpaRepository<InformationEvent, InformationEvent.InformationEventId> {
}
