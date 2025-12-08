package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.InformationEvent;
import at.spengergasse.plue.dtos.InformationEventSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InformationEventRepository extends JpaRepository<InformationEvent, InformationEvent.InformationEventId> {

    @Query("SELECT new at.spengergasse.plue.dtos.InformationEventSummary(ie) FROM InformationEvent ie")
    List<InformationEventSummary> findAllSummary();
}
